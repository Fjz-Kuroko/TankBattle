package swingPackages;

import java.util.Arrays;
import java.util.Stack;

public class Calculate {
	
	//保存计算的式子
	private String Formula;
	static Stack<Double> num_stack = new Stack<Double>();
	static Stack<Character> opt_stack = new Stack<Character>();
	/**
	 * 计算优先级函数
	 * @param c 计算符号，包括左括号
	 * @return 返回符号的优先级
	 */
	public int priority(char c){
		int pro=0;
		switch(c){
		case '(':
			pro = 3;
			break;
		case '*':
		case '/':
			pro = 2;
			break;
		case '+':
		case '-':
			pro = 1;
			break;
		default:
			pro = 0;
			break;
		}
		return pro;		
	}
	
	public Calculate(String Formula){
		this.Formula = Formula;
	}
	
	/**
	 * 计算函数
	 * @return 返回式子计算的结果
	 */
	public double calculation(){
		char[] input = new char[1024];
		Arrays.fill(input, '\0');
		int i = 0,j = 0;
		double num1 = 0,num2 = 0;
		double tmp = 0.0;
		//判断是否为负号
		boolean isMinus = false;
		//判断是否为负数
		boolean isNegative = false;
		//记录负号位置
		int posMinus = 0;
		char[] ss = Formula.toCharArray();
		for(int k=0;k<ss.length;k++){
			input[k] = ss[k];
		}
		while(input[i]!='\0' || opt_stack.empty()){
			if(input[i]=='-'){
				isMinus = true;
				posMinus = i;
			}
			else
				isMinus = false;
			if(isMinus){
				if(posMinus==0){
					isNegative = true;
				}
				else{
					if(input[posMinus-1]=='('){
						isNegative = true;
					}
				}
			}
			if((input[i]>='0'&&input[i]<='9')||input[i]=='.'||(isNegative&&input[i]=='-')){
				String num = "";				
				i++;
				if((input[i]>'9' || input[i]<'0')&&(input[i]!='.')){
					for(int k = j;k < i;k++){
						if((input[k]>='0'&&input[k]<='9')||input[k]=='.'||(isNegative&&input[k]=='-'))
							num = num + String.valueOf(input[k]);
					}
					if(num!=null){
						tmp = Double.parseDouble(num);
						isNegative = false;
					}
					num_stack.push(tmp);
					tmp = 0.0;
					j=i+1;
				}
			}
			else{
				if((input[i] == ')')&&(opt_stack.peek()=='(')){
					opt_stack.pop();
					i++;
					continue;
				}
				if(opt_stack.empty()||(priority(input[i])>priority(opt_stack.peek()))||(opt_stack.peek()=='('&&(input[i]!=')'))){
					opt_stack.push(input[i]);
					i++;
					continue;
				}
				if(((input[i] == '\0')&&opt_stack.empty()) || ( (input[i]==')')&&(opt_stack.peek()!='(')) ||(priority(input[i])<=priority(opt_stack.peek())) ){
					char ch = opt_stack.pop();
					switch(ch){
					case'+':
						num1 = num_stack.pop();
						num2 = num_stack.pop();
						num_stack.push(num1+num2);
						break;
					case'-':
						num1 = num_stack.pop();
						num2 = num_stack.pop();
						num_stack.push(num2-num1);
						break;
					case'*':
						num1 = num_stack.pop();
						num2 = num_stack.pop();
						num_stack.push(num1*num2);
						break;
					case'/':
						num1 = num_stack.pop();
						num2 = num_stack.pop();
						num_stack.push(num2/num1);
						break;
					}
				}
			}
		}
		//System.out.println(num_stack.peek());
		return num_stack.peek();	
	}
}
