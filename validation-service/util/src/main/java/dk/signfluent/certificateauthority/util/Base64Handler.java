package dk.signfluent.certificateauthority.util;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import java.util.Base64;

@Service
public class Base64Handler {

    public X509Certificate parseX509(String Base64X509Certificate) throws CertificateException {
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        return (X509Certificate) instance.generateCertificate(new ByteArrayInputStream(parseData(Base64X509Certificate)));
    }

    public byte[] parseData(String data) {
        return Base64.getDecoder().decode(data);
    }

    public String encodeX509(X509Certificate certificate) throws CertificateEncodingException {
        return Base64.getEncoder().encodeToString(certificate.getEncoded());
    }

    public String encodeData(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}
