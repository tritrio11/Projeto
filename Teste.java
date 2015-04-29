import java.util.*;
import java.lang.Object;

enum OPS{
	pushf, pushs, err, check, jump, jz, pusha,
	add, sub, mul, div, mod, not, inf, infeq, sup, supeq,
	fadd, fsub, fmul, fdiv, fcos, fsin,
	finf, finfeq, fsup, fsupeq,
	concat, equal, atoi, atof, itof, ftoi, stri, strf,
	pushsp, pushfp, pushgp, loadn, storen, swap,
	writei, writef, writes, read, call, return1,
	start, nop, stop, allocn, free, dupn, popn,
	pushi, pushn, pushg, pushl, load, dup, pop,
	storel, storeg, alloc
}

class Code{
	
	int operador;
	
	int opi1;
	int opi2;
	String ops;
	float opf;
	
	public Code(int op){
		this.operador=op;
	}
	
	public Code(int op, int opi){
		this.operador=op;
		this.opi1=opi;
	}
	
	public Code(int op, int op1, int op2){
		this.operador=op;
		this.opi1=op1;
		this.opi2=op2;
	}
	
	public Code(int op, String s){
		this.operador=op;
		this.ops=new String(s);
	}
	
	public Code(int op, float f){
		this.operador=op;
		this.opf=f;
	}
	
	public int getOperador(){
		return this.operador;
	}
	
	//Falta o <ident>
}




class CallStack{
	
	int callS[][]= new int [100][2]; //par de apontadores
	int i=0;
	int pc;//para guardar registo pc
	int fp;//para guardar registo fp
	
	
	
	public void aponta(int p ){// ,int fp){ //metodo para guardar as chamadas
		this.pc = p;
		callS[i][0]=pc;
		System.out.print(callS[i][0]);
		System.out.println("<-aqui call stack");
		i++;
	}
}





class MyHeap{
	
	int hint;
	float hreal;
	//endereco??
}


class MyStrings{
	
	String palavra;
}



class Maquina{
	
	int pc = 0;
	Code code[] = new Code[100];
	CallStack cs =new CallStack();
	int opStack[]=new int[10000];
	
	int sp=0;
	int gp=0;
	int fp;//??
	
	public void preencheCod() {
		
		/*Exemplo*/
		code[pc]= new Code(OPS.pushi.ordinal(), 5); 
		cs.aponta(pc);
		pc++;
		code[pc]=new Code(OPS.pushs.ordinal(),"ola");
		cs.aponta(pc);
		pc++;
		code[pc]=new Code(OPS.pushn.ordinal(),3);
		cs.aponta(pc);
		pc++;
	}
}


class Main{
	
	public static void main(String args[]){
		Maquina mq = new Maquina();
		CallStack cs = new CallStack();
		
		
		mq.preencheCod();
		
		//pc=1
		System.out.println(mq.code[0].operador);
		System.out.println(mq.code[0].opi1);
		//pc=2
		System.out.println(mq.code[1].operador);
		System.out.println(mq.code[1].ops);
		//pc=3
		System.out.println(mq.code[2].operador);
	
		if(mq.code[0].getOperador()==OPS.pushi.ordinal()){
		System.out.println("ok!");}
	}
}

