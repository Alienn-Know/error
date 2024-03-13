@Tag("parent-template")
@JsModule("./com/example/parent-template.ts")
public class ParentTemplate extends LitTemplate {

    @Id("childTemplate")
    private ChildTemplate child;
}