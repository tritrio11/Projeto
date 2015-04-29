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

////AAAAAAAALLLOOOO

class Code{
	
	int operador; //e para doubles/reais? outros operadores?
	
	int opi1;
	int opi2;
	String ops;
	
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
	
	public int getOperador(){
		return this.operador;
	}
}




class CallStack{
	
	int callS[][]= new int [100][2]; //par de apontadores
	int i=0;
	int apc;//para guardar registo pc
	int afp;//para guardar registo fp
	
	
	
	public void aponta(int pc ){// ,int fp){ //metodo para guardar as chamadas
		this.apc = pc;
		callS[i][0]=apc;
		System.out.print(callS[i][0]);
		System.out.println("<-aqui call stack");
		i++;
		
	}
	
	
}




class OpStack{

		int sp=0;
		int gp=0;
		int fp;
}


class MyHeap{
	
	int operador; //e para doubles/reais? outros operadores?
	
	int opi1;
	int opi2;
	String ops;
	
}


class MyStrings{
	
	String palavra;
	
}



class Maquina{
	
	int pc = 0;
	Code code[] = new Code[100];
	CallStack cs =new CallStack();
	
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
		
	//Waaaaaaaaaaaat??
	/*
		System.out.println(cs.callS[0][0]);
		System.out.println(cs.callS[1][0]);
		System.out.println(cs.callS[2][0]);
		*/
	}
	
	
}

