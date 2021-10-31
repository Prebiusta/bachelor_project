import 'package:test/test.dart';
import 'package:bpm_service_api/bpm_service_api.dart';


/// tests for CertificateAuthorityControllerApi
void main() {
  final instance = BpmServiceApi().getCertificateAuthorityControllerApi();

  group(CertificateAuthorityControllerApi, () {
    // Issues X509 Certificate and returns in PEM format
    //
    //Future<String> issueX509Certificate(IssueX509CertificateRequest issueX509CertificateRequest) async
    test('test issueX509Certificate', () async {
      // TODO
    });

  });
}
