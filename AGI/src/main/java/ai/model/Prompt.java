package ai.model;

public class Prompt {

    private String username;
    private String prompt;

    private String etc;

    public Prompt(String username, String prompt, String etc){
        this.username = username;
        this.prompt = prompt;
        this.etc = etc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    @Override
    public String toString() {
        return "Prompt{" +
                "username='" + username + '\'' +
                ", prompt='" + prompt + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }
}
