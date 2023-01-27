package com.craftinginterpreters.lox;
import java.util.List;
abstract class Stmt {
    interface Visitor<R> {
        R visitPrintStmt(com.craftinginterpreters.lox.Stmt.Print expr);
        R visitExpressionStmt(com.craftinginterpreters.lox.Stmt.Expression expr);
        R visitBlockStmt(Block stmt);
        R visitIfStmt(If stmt);
        R visitWhileStmt(While stmt);
        R visitVarStmt(Var stmt);

    }
  static class Print extends Stmt {
    Print(Expr expression) {
      this.expression = expression;
}
    final Expr expression;
    @Override
    <R> R accept(com.craftinginterpreters.lox.Stmt.Visitor<R> visitor) {
          return visitor.visitPrintStmt(this);
      }
}
  static class Expression extends Stmt {
    Expression(Expr expression) {
      this.expression = expression;
}
    final Expr expression;
    @Override
    <R> R accept(com.craftinginterpreters.lox.Stmt.Visitor<R> visitor) {
          return visitor.visitExpressionStmt(this);
      }

  }
    static class Var extends Stmt {
        Var(Token name, Expr initializer) {
            this.name = name;
            this.initializer = initializer;
        }

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitVarStmt(this);
        }

        final Token name;
        final Expr initializer;
    }
    static class Block extends Stmt {
        Block(List<Stmt> statements) {
            this.statements = statements;
        }

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitBlockStmt(this);
        }

        final List<Stmt> statements;
    }

    static class If extends Stmt {
        If(Expr condition, Stmt thenBranch, Stmt elseBranch) {
            this.condition = condition;
            this.thenBranch = thenBranch;
            this.elseBranch = elseBranch;
        }

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitIfStmt(this);
        }

        final Expr condition;
        final Stmt thenBranch;
        final Stmt elseBranch;
    }
    static class While extends Stmt {
        While(Expr condition, Stmt body) {
            this.condition = condition;
            this.body = body;
        }

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitWhileStmt(this);
        }

        final Expr condition;
        final Stmt body;
    }
    abstract <R> R accept(com.craftinginterpreters.lox.Stmt.Visitor<R> visitor);

}