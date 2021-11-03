import 'package:openapi_generator_annotations/openapi_generator_annotations.dart';

@Openapi(
    additionalProperties:
    AdditionalProperties(pubName: 'bpm_service_api', pubAuthor: 'Signfluent', prependFormOrBodyParameters: true),
    inputSpecFile: 'lib/src/api/bpm-service-api-spec.json',
    generatorName: Generator.dioNext,
    outputDirectory: 'api/bpm-service-api',
    alwaysRun: true,
)
class OpenapiSpecs extends OpenapiGeneratorConfig {
}

/// flutter pub run build_runner build --delete-conflicting-outputs
