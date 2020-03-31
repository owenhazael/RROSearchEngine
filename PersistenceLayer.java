//import
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
/*
 * @author Roland Colon III
 */
//persistently stores data
public class PersistenceLayer
{
    private List<File> fileName = new ArrayList<>();
    public PersistenceLayer()
    {
        fileName.add(new File("fileName", "path"));
    }
    
    @Override
    public Optional<File> get(long fileName)
    {
        return Optional.ofNullable(files.get((int) id));
    }
    
    @Override
    public List<File> getAll()
    {
        return files;
    }
    
    @Override
    public void save(File file)
    {
        files.add(file);
    }
    
    @Override
    public void update(File file, String[] params)
    {
        file.setName(Objects.requireNonNull(params[0], "Name of file can not be null"));
        file.setPath(Objects.requireNonNull(params[1], "path can not be null"));
        files.add(file);
    }
    
    @Override
    public void delete(File file)
    {
        files.remove(file);
    }
}
