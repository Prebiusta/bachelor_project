package dk.signfluent.certificateauthority.util;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

@Mapper(componentModel = "spring")
public abstract class Base64Mapper {
    @Named("base64ToBytes")
    protected byte[] base64ToBytes(String base64) {
        return Base64.getDecoder().decode(base64);
    }

    @Named("base64ToX509")
    protected X509Certificate base64ToX509(String Base64X509Certificate) throws CertificateException {
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        return (X509Certificate) instance.generateCertificate(new ByteArrayInputStream(base64ToBytes(Base64X509Certificate)));
    }
}
