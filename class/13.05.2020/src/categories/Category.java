package categories;

public class Category {
    protected String code;
    protected String name;

    public Category() {
        this("defaultCode", "defaultName");
    }

    public Category(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
