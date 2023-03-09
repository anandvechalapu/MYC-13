

@Service
public class OpenAICodeGenerationService {

    @Autowired
    private DatabaseService databaseService;
    
    @Autowired
    private OpenAIService openAIService;
    
    public boolean generateCode(String userStory, ProjectDetails projectDetails) {
        //Create request in the database to track the status of the code generation process.
        databaseService.createCodeGenerationRequest(userStory, projectDetails);
        
        //Send request to OpenAI to generate the code
        OpenAICodeGenerationResponse response = openAIService.generateCode(userStory, projectDetails);
        
        //If OpenAI code generation is successful
        if (response.isSuccess()) {
            //Display the generated code to the user in a readable format
            displayGeneratedCode(response.getGeneratedCode());
            
            //Store the generated code in the database along with the GitHub link information
            databaseService.storeGeneratedCode(userStory, projectDetails, response.getGeneratedCode(), response.getGithubLink());
            
            return true;
        }
        
        return false;
    }
    
    private void displayGeneratedCode(String generatedCode) {
        //Display the code to the user in a readable format
    }
}