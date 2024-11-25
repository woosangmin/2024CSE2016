public class PayrollController {
    public void processPayroll(String in, String out) {
        PayrollReader reader = new PayrollReader(in);
        PayrollWriter writer = new PayrollWriter(out);
        while (reader.getNextRecord()) {
            int payment = reader.hoursOf() * reader.payrateOf();
            writer.printCheck(reader.nameOf(), payment);
        }
        writer.printCheck("!");
        reader.close();
        writer.close();
    }
}
