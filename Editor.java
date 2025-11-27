public class Editor {
    private String text = "";
    
    public void setText(String novoTexto) {
        this.text = novoTexto;
    }
    
    public String getText() {
        return text;
    }
    
    public Snapshot createSnapshot() {
        return new Snapshot(text);
    }
    
    public void restore(Snapshot snapshot) {
        this.text = snapshot.getText();
    }
}