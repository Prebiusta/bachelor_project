package dk.signfluent.certificateauthority.certificatemanagement.services;

import dk.signfluent.certificateauthority.certificatemanagement.model.CAConfigurationValues;
import org.bouncycastle.asn1.x500.X500Name;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;

@Service
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
        return new X500Name(((X509Certificate)keyStore.getCertificate(alias)).getIssuerDN().getName());
    }

    private KeyStore getKeyStore() throws KeyStoreException, CertificateException, IOException, NoSuchAlgorithmException {
        KeyStore keyStore = KeyStore.getInstance(caConfigurationValues.getKeystoreType());

        Resource resource = new ClassPathResource(caConfigurationValues.getCertificatePath());
        InputStream inputStream = resource.getInputStream();
        byte[] fileContent = FileCopyUtils.copyToByteArray(inputStream);

        keyStore.load(
                new ByteArrayInputStream(fileContent),
                caConfigurationValues.getKeystorePassword().toCharArray()
        );

        return keyStore;
    }
}
