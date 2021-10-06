package dk.signfluent.certificateauthority.certificatemanagement.services;

import dk.signfluent.certificateauthority.certificatemanagement.network.IssueX509CertificateRequest;
import org.springframework.stereotype.Service;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.Date;

@Service
public class CertificateService {
    private final CertificateDetailsService certificateDetailsService;

    public CertificateService(CertificateDetailsService certificateDetailsService) {
        this.certificateDetailsService = certificateDetailsService;
    }

    public X509Certificate issueX509Certificate(IssueX509CertificateRequest issueX509CertificateRequest) {
        try {
            X509v3CertificateBuilder builder = getX509v3CertificateBuilder(issueX509CertificateRequest);
            return signCertificateByCA(builder);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private X509v3CertificateBuilder getX509v3CertificateBuilder(IssueX509CertificateRequest issueX509CertificateRequest) throws NoSuchAlgorithmException, InvalidKeySpecException, CertificateException, KeyStoreException, IOException {
        return new X509v3CertificateBuilder(
                generateIssuerName(),
                generateSerialNumber(),
                generateIssueDate(),
                generateExpiryDate(),
                getSubjectName(issueX509CertificateRequest),
                extractSubjectPublicKeyInfo(issueX509CertificateRequest)
        );
    }

    private X500Name generateIssuerName() throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException {
        return certificateDetailsService.getCAName();
    }

    private BigInteger generateSerialNumber() {
        return BigInteger.valueOf(System.currentTimeMillis());
    }

    private X500Name getSubjectName(IssueX509CertificateRequest issueX509CertificateRequest) {
        return new X500Name("dn=" + issueX509CertificateRequest.getUserId());
    }

    private Date generateIssueDate() {
        return new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
    }

    private Date generateExpiryDate() {
        return new Date(System.currentTimeMillis() + 2L * 365 * 24 * 60 * 60 * 1000);
    }

    private SubjectPublicKeyInfo extractSubjectPublicKeyInfo(IssueX509CertificateRequest issueX509CertificateRequest) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return SubjectPublicKeyInfo.getInstance(SubjectPublicKeyInfo.getInstance(
                ASN1Sequence.getInstance(extractRSAPublicKey(issueX509CertificateRequest).getEncoded())
        ));
    }

    private PublicKey extractRSAPublicKey(IssueX509CertificateRequest issueX509CertificateRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory fact = KeyFactory.getInstance("RSA");
        ASN1Sequence seq = ASN1Sequence.getInstance(Base64.getDecoder().decode(getBase64PublicKey(issueX509CertificateRequest)));
        org.bouncycastle.asn1.pkcs.RSAPublicKey key = org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(seq);
        RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(key.getModulus(), key.getPublicExponent());
        return fact.generatePublic(pubSpec);
    }

    private String getBase64PublicKey(IssueX509CertificateRequest issueX509CertificateRequest) {
        return issueX509CertificateRequest.getPublicKeyPem()
                .replaceAll("\\n", "")
                .replaceAll("\\r", "")
                .replace("-----BEGIN RSA PUBLIC KEY-----", "")
                .replace("-----END RSA PUBLIC KEY-----", "");
    }

    private X509Certificate signCertificateByCA(X509v3CertificateBuilder builder) throws OperatorCreationException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException, UnrecoverableKeyException, KeyStoreException, IOException {
        ContentSigner signer = new JcaContentSignerBuilder("SHA256WithRSAEncryption").build(certificateDetailsService.getCAPrivateKey());
        X509CertificateHolder certHolder = builder.build(signer);
        X509Certificate cert = new JcaX509CertificateConverter().setProvider(new BouncyCastleProvider()).getCertificate(certHolder);
        cert.verify(certificateDetailsService.getCAPublicKey());
        return cert;
    }
}
