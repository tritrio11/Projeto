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


class CallStack{
	
	int callS[][]= new int [100][2];
	int i=0;
	int apc;
	int afp;
	
	public void aponta(int pc){
		this.apc = pc;
		callS[i][0]=apc;
		System.out.println(callS[i][0]);
		i++;
		
	}
	
	
}



class Maquina{
	
	int pc = 0;
	Code code[];
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
		
		System.out.println(mq.code[0]);
		System.out.println(mq.code[1]);
		System.out.println(mq.code[2]);
	
		if(mq.code[0].getOperador()==OPS.pushi.ordinal()){
		System.out.println("ok!");}
		
	//Waaaaaaaaaaaat??
		System.out.println(cs.callS[0][0]);
		System.out.println(cs.callS[1][0]);
		System.out.println(cs.callS[2][0]);
		
	}
	
	
}


class Code{
	int operador;
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
