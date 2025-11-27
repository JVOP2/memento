import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Snapshot> snapshots = new ArrayList<>();
    private List<Snapshot> redoSnapshots = new ArrayList<>();
    
    public void save(Snapshot snapshot) {
        snapshots.add(snapshot);
        redoSnapshots.clear(); // Limpa redo ao fazer nova ação
    }
    
    public Snapshot undo() {
        if (snapshots.isEmpty()) {
            return null;
        }
        
        Snapshot current = snapshots.remove(snapshots.size() - 1);
        redoSnapshots.add(current);
        
        return snapshots.isEmpty() ? null : snapshots.get(snapshots.size() - 1);
    }
    
    public Snapshot redo() {
        if (redoSnapshots.isEmpty()) {
            return null;
        }
        
        Snapshot snapshot = redoSnapshots.remove(redoSnapshots.size() - 1);
        snapshots.add(snapshot);
        return snapshot;
    }
    
    public boolean canUndo() {
        return !snapshots.isEmpty();
    }
    
    public boolean canRedo() {
        return !redoSnapshots.isEmpty();
    }
}