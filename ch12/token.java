package ch12;
public class token {
  public int id;
  public int cat;
  public String text;
  public int lineno;
  public typeinfo typ;
  public token(int c, String s, int l) {
    cat = c; text = s; lineno = l;
    id = serial.getid();
    switch (cat) {
    case parser.INT: typ = new typeinfo("int"); break;
    case parser.DOUBLE: typ = new typeinfo("double"); break;
    case parser.BOOLEAN: typ = new typeinfo("boolean"); break;
    case parser.VOID: typ = new typeinfo("void"); break;
    case parser.INTLIT: typ = new typeinfo("int"); break;
    case parser.DOUBLELIT: typ = new typeinfo("double"); break;
    case parser.STRINGLIT: typ = new typeinfo("String"); break;
    case parser.BOOLLIT: typ = new typeinfo("boolean"); break;
    case parser.NULLVAL: typ = new typeinfo("null"); break;
    case '=': case '+': case '-': typ = new typeinfo("n/a"); break;
    }
   }
public typeinfo type(symtab stab) {
  symtab_entry rv;
  if (typ != null) return typ;
  if (cat == parser.IDENTIFIER)
      if ((rv = stab.lookup(text)) != null) return typ=rv.typ;
  j0.semErr("cannot check the type of " + text);
  return null;
}
}
