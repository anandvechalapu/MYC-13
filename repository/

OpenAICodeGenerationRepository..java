

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface OpenAICodeGenerationRepository extends JpaRepository<OpenAICodeGeneration, Long> {
 
    OpenAICodeGeneration findByUserStoryAndProjectDetails(String userStory, String projectDetails);
 
    OpenAICodeGeneration findByRequestId(Long requestId);
 
    OpenAICodeGeneration findByCodeGenerationSuccessful(Boolean codeGenerationSuccessful);
 
    OpenAICodeGeneration findByGeneratedCodeAndGitHubLink(String generatedCode, String gitHubLink);
 
}