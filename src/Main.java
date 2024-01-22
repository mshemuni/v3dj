//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        V3D v3ctor = new V3D(1, 1, 1);
        V3D v3ctor2 = new V3D(3, 2, 4);

        v3ctor.Add(v3ctor2).Print();
    }
}