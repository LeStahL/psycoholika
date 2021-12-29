from build.SynthGraphVisitor import *
from build.SynthGraphParser import *

class GenerateGLSLVisitor(ParseTreeVisitor):
    def __init__(self):
        self.shaderSource = ""

    # Visit a parse tree produced by SynthGraphParser#synth_file.
    def visitSynth_file(self, ctx:SynthGraphParser.Synth_fileContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SynthGraphParser#synth_node.
    def visitSynth_node(self, ctx:SynthGraphParser.Synth_nodeContext):
        print(f"Node: {ctx.name}")
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SynthGraphParser#synth_parameter_assignment.
    def visitSynth_parameter_assignment(self, ctx:SynthGraphParser.Synth_parameter_assignmentContext):
        print(f"ParameterAssignment: {ctx.name} = {ctx.value}")
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SynthGraphParser#synth_node_type.
    def visitSynth_node_type(self, ctx:SynthGraphParser.Synth_node_typeContext):
        print(f"NodeType: {ctx.atom}")
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SynthGraphParser#synth_expression.
    def visitSynth_expression(self, ctx:SynthGraphParser.Synth_expressionContext):
        print(f"Expression: {ctx.getText()}")
        return self.visitChildren(ctx)

     # Visit a parse tree produced by SynthGraphParser#synth_value.
    def visitSynth_value(self, ctx:SynthGraphParser.Synth_valueContext):
        print(f"Value: {ctx.atom}")
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SynthGraphParser#synth_operator.
    def visitSynth_operator(self, ctx:SynthGraphParser.Synth_operatorContext):
        print(f"Operator: {ctx.getText()}")
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SynthGraphParser#synth_parameter_name.
    def visitSynth_parameter_name(self, ctx:SynthGraphParser.Synth_parameter_nameContext):
        print(f"ParameterName: {ctx.getText()}")
        return self.visitChildren(ctx)

    # def visitNumberExpr(self, ctx):
    #     print("Number.")
    #     value = ctx.getText()
    #     return int(value)

    # def visitParenExpr(self, ctx):
    #     print("Parenthesis.")
    #     return self.visit(ctx.expr())

    # def visitInfixExpr(self, ctx):
    #     l = self.visit(ctx.left)
    #     r = self.visit(ctx.right)

    #     op = ctx.op.text
    #     operation =  {
    #     '+': lambda: l + r,
    #     '-': lambda: l - r,
    #     '*': lambda: l * r,
    #     '/': lambda: l / r,
    #     }
    #     return operation.get(op, lambda: None)()

    # def visitByeExpr(self, ctx):
    #     print(f"goodbye")
    #     sys.exit(0)

    # def visitHelloExpr(self, ctx):
    #     return (f"{ctx.getText()}")
