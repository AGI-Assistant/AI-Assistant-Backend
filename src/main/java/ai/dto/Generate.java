package ai.dto;


public class Generate  {
    private String prompt;


    public Generate( String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public String toString() {
        return "{" +
                "prompt='" + prompt + '\'' +
                '}';
    }
}
