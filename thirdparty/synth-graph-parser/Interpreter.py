from antlr4 import *

import build.SynthGraphVisitor
import build.SynthGraphLexer
import build.SynthGraphParser
import GenerateGLSLVisitor

if __name__ == "__main__":
    while 1:
        data =  InputStream(input(">>> "))
        # lexer
        lexer = build.SynthGraphLexer.SynthGraphLexer(data)
        stream = CommonTokenStream(lexer)
        # parser
        parser = build.SynthGraphParser.SynthGraphParser(stream)
        tree = parser.synth_file()
        # evaluator
        visitor = GenerateGLSLVisitor.GenerateGLSLVisitor()
        output = visitor.visit(tree)
        print(output)
