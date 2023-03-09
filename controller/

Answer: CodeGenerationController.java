

@RestController
public class CodeGenerationController {

    private final CodeGenerationService codeGenerationService;

    public CodeGenerationController(CodeGenerationService codeGenerationService) {
        this.codeGenerationService = codeGenerationService;
    }

    @PostMapping("/generate-code")
    public ResponseEntity<GeneratedCode> generateCode(@RequestBody CodeGenerationRequest codeGenerationRequest) {
        GeneratedCode generatedCode = codeGenerationService.generateCode(codeGenerationRequest);
        return ResponseEntity.ok(generatedCode);
    }

    @GetMapping("/track-status/{requestId}")
    public ResponseEntity<GenerationStatus> trackStatus(@PathVariable("requestId") String requestId) {
        GenerationStatus generationStatus = codeGenerationService.trackStatus(requestId);
        return ResponseEntity.ok(generationStatus);
    }

    @GetMapping("/get-generated-code/{requestId}")
    public ResponseEntity<GeneratedCode> getGeneratedCode(@PathVariable("requestId") String requestId) {
        GeneratedCode generatedCode = codeGenerationService.getGeneratedCode(requestId);
        return ResponseEntity.ok(generatedCode);
    }
}