package dk.signfluent.certificateauthority.certificatemanagement.services;

import dk.signfluent.certificateauthority.certificatemanagement.model.CAConfigurationValues;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.x500.X500Name;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;

@Service
@Slf4j
public class CertificateDetailsService {
    private final CAConfigurationValues caConfigurationValues;

    public CertificateDetailsService(CAConfigurationValues caConfigurationValues) {
        this.caConfigurationValues = caConfigurationValues;
    }

    public PublicKey getCAPublicKey() throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException {
        KeyStore keyStore = getKeyStore();
        String alias = keyStore.aliases().nextElement();
        return keyStore.getCertificate(alias).getPublicKey();
    }

    public PrivateKey getCAPrivateKey() throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException, UnrecoverableKeyException {
        KeyStore keyStore = getKeyStore();
        String alias = keyStore.aliases().nextElement();
        return (PrivateKey) keyStore.getKey(alias, caConfigurationValues.getKeystorePassword().toCharArray());
    }

    public X500Name getCAName() throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException {
        KeyStore keyStore = getKeyStore();
        String alias = keyStore.aliases().nextElement();
        return new X500Name(((X509Certificate) keyStore.getCertificate(alias)).getIssuerDN().getName());
    }

    private KeyStore getKeyStore() throws KeyStoreException, CertificateException, IOException, NoSuchAlgorithmException {
        KeyStore keyStore = KeyStore.getInstance(caConfigurationValues.getKeystoreType());

        byte[] fileContent = Base64.getDecoder().decode(caConfigurationValues.getCertificatePem());

        keyStore.load(
                new ByteArrayInputStream(fileContent),
                caConfigurationValues.getKeystorePassword().toCharArray()
        );

        return keyStore;
    }
}
