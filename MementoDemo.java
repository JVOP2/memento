public class MementoDemo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();
        
        // Salva estado inicial
        history.save(editor.createSnapshot());
        
        // Primeira edição
        editor.setText("Primeira linha");
        System.out.println("Texto atual: " + editor.getText());
        history.save(editor.createSnapshot());
        
        // Segunda edição
        editor.setText("Primeira linha\nSegunda linha");
        System.out.println("Texto atual: " + editor.getText());
        history.save(editor.createSnapshot());
        
        // Terceira edição
        editor.setText("Primeira linha\nSegunda linha\nTerceira linha");
        System.out.println("Texto atual: " + editor.getText());
        history.save(editor.createSnapshot());
        
        // Testando Undo
        System.out.println("\n--- Testando Undo ---");
        Snapshot snapshot = history.undo();
        if (snapshot != null) {
            editor.restore(snapshot);
            System.out.println("Após undo: " + editor.getText());
        }
        
        snapshot = history.undo();
        if (snapshot != null) {
            editor.restore(snapshot);
            System.out.println("Após segundo undo: " + editor.getText());
        }
        
        // Testando Redo
        System.out.println("\n--- Testando Redo ---");
        snapshot = history.redo();
        if (snapshot != null) {
            editor.restore(snapshot);
            System.out.println("Após redo: " + editor.getText());
        }
        
        snapshot = history.redo();
        if (snapshot != null) {
            editor.restore(snapshot);
            System.out.println("Após segundo redo: " + editor.getText());
        }
    }
}