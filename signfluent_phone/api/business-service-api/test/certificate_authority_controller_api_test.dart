import 'package:test/test.dart';
import 'package:business_service_api/business_service_api.dart';


/// tests for CertificateAuthorityControllerApi
void main() {
  final instance = BusinessServiceApi().getCertificateAuthorityControllerApi();

  group(CertificateAuthorityControllerApi, () {
    // Issues X509 Certificate and returns in PEM format
    //
    //Future<String> issueX509Certificate(IssueX509CertificateRequest issueX509CertificateRequest) async
    test('test issueX509Certificate', () async {
      // TODO
    });

  });
}
