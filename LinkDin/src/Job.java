import java.util.ArrayList;
import java.util.List;

public class Job {
    private final int jobId;
    private List<String> tags;
    public Job(int jobId){
        this.jobId = jobId;
        this.tags = new ArrayList<>();
    }
    public void setTags(List<String> tagList){
        this.tags = tagList;
    }

    public List<String> getTags(){
        return tags;
    }
}
