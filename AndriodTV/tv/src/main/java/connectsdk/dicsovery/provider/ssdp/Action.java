package connectsdk.dicsovery.provider.ssdp;

        import java.util.List;


public class Action {
    /* Required. Name of action. */
    String mName;

    /* Required. */
    List<Argument> mArgumentList;

    public Action(String name) {
        this.mName = name;
    }
}
