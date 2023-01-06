def defineType(writer,baseName,ClassName,fields):
    writer.write("  static class " + ClassName + " extends " +
        baseName + " {\n")
    writer.write("    " + ClassName + "(" + fields + ") {\n")
    fieldss = fields.split(", ")
    for field in fieldss:
      name = field.split(" ")[1]
      writer.write("      this." + name + " = " + name + ";\n")
    writer.write('}\n')
    for field in fieldss:
      writer.write("    final " + field + ";\n")
    writer.write("}\n")
    
    
def defineAst(baseName, types):
    file1 = open("/home/saifk/Projects/CrafInt/myAttempts/Jlox2/src/SLox/" + baseName + ".java", "w") 
    file1.write("package com.craftinginterpreters.lox;\nimport java.util.List;\nabstract class " + baseName + " {\n")
    for type in types:
        className = type.split(":")[0].strip()
        fields = type.split(":")[1].strip()
        defineType(file1,baseName,className,fields)
    file1.write("}")


defineAst("Stmt", {"Expression : Expr expression",
      "Print      : Expr expression"})

