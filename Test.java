package SLox;
import java.util.List;
abstract class Test {
  static class Binary extends Test {
    Binary(Expr left, Token operator, Expr right) {
      this.left = left;
      this.operator = operator;
      this.right = right;
}
    final Expr left;
    final Token operator;
    final Expr right;
}
  static class Literal extends Test {
    Literal(Object value) {
      this.value = value;
}
    final Object value;
}
  static class Grouping extends Test {
    Grouping(Expr expression) {
      this.expression = expression;
}
    final Expr expression;
}
  static class Unary extends Test {
    Unary(Token operator, Expr right) {
      this.operator = operator;
      this.right = right;
}
    final Token operator;
    final Expr right;
}
}