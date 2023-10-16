import java.util.ArrayList;


public class AlgebraicCalculator {
	public static double Calculate(String Original)
	{
		String[] Break=Break(Original);
		//�ָ�ԭʼ����
		boolean  InputCheck=InputCheck(Break);	
		//���ԭʼ�����Ƿ�Ϸ�������
		if (InputCheck==true)
		{
			double[] Numbers=BreakNumbers(Break);
			//���ָ�������е������������
			String[] Operations=BreakOperations(Break);
			//���ָ�������е�������������
			int[]    Orders=BreakOrders(Break);
			//���ָ�������е��������ȼ����¶�ȡ
		    return   Calculate(Numbers,Operations,Orders);
		    //���ؼ��㺯��������
		}
		else
		{
			return 0;
			//��ԭʼ���ݷǷ����򲻵������㺯��
		}
	}
	public static String[] Break (String original)
       {
		    String[] Break=original.split(" ");
		    return Break;
       }
	public static boolean InputCheck (String[] ORG)
	{
		boolean result=true;	
		int NLP=0;
		//NLP=number of left parenthesis
		int NRP=0;
		//NRP=number of right parenthesis
		for (int i=0; i<ORG.length-1; i++)
		{
			if (ORG[i].equals("("))
				//������ŶԳ���
				{
					NLP++;
				}
				if (ORG[i].equals(")"))
				{
					NRP++;
				}
				if (ORG[i].equals("=")&&(!(i==ORG.length-1)))
			    //����Ƿ�Ϊ��ʽ
				{
					System.out.println("Error: Can not input function or equation");
				}
			if(ORG[i].equals("+")||ORG[i].equals("-")||ORG[i].equals("*")||ORG[i].equals("/")||ORG[i].equals("^"))
			//���������Ƿ�����
			{
				if(ORG[i+1].equals("+")||ORG[i+1].equals("-")||ORG[i+1].equals("*")||ORG[i+1].equals("/")||ORG[i+1].equals("^")||ORG[i+1].equals("=")||ORG[i+1].equals(")"))
				{
					System.out.println("Error: The operater '"+ORG[i]+"' can not connected with '"+ORG[i+1]+"'");
					result=false;
				}
			}
		}
		if (!(NLP==NRP))
		//������ŶԳ���
		{
			System.out.println("Error: The number of left parenthesises does not equal to the number of right parenthsises");
		    result=false;
		}
		if (!ORG[ORG.length-1].equals("="))
		{
			result=false;
			System.out.println("Error: The last sign is not the equal sign");
		}
		return result;
	}
    public static double[] BreakNumbers (String[] ORG)
	{
        int QN=0;
		//Quantity of number
		//�����ʽ�м�����
		int NL=0;
		//NumberLength
		//������м�λ
		//���ֵ�����Ŵ���д
		int PD=0;
		//Position of dot
		//���ڱ�ʾС�����λ��
		ArrayList<Double> Numbers=new ArrayList<Double>();
		//������ʱ���������ϵ���
		for(int i=0; i<ORG.length; i++)
		{
		    if (ORG[i].equals("0")||ORG[i].equals("1")||ORG[i].equals("2")||ORG[i].equals("3")||ORG[i].equals("4")||ORG[i].equals("5")||ORG[i].equals("6")||ORG[i].equals("7")||ORG[i].equals("8")||ORG[i].equals("9")||ORG[i].equals("."))
		    {
			//�ж���һλ�ǲ���һ�����ֻ���С����
		        if(!ORG[i].equals("."))
		        {
		        	 NL++;
		        	//��������֣���ô�����ֵĳ���+1
		        }
		        else
		        {
		        	PD=NL;
		        	//�����С���㣬��ôС����λ��=��ǰ���ֳ��ȣ�
		        }
		    //�����ж���һλ�ǲ�������
			    if(!(ORG[i+1].equals("0")||ORG[i+1].equals("1")||ORG[i+1].equals("2")||ORG[i+1].equals("3")||ORG[i+1].equals("4")||ORG[i+1].equals("5")||ORG[i+1].equals("6")||ORG[i+1].equals("7")||ORG[i+1].equals("8")||ORG[i+1].equals("9")||ORG[i+1].equals(".")))
			    {
			    	//�����һλ�������֣�˵�������������
			    	//��ʼ�����һ������һ����̬������
			    	int[] NIP=new int[NL];
		    		//��λ������������NIP[0],ʮλ����������NIP[1]���Դ�����
		    		//NIP=Numbers in position
			    	if(PD==0)
			    	{
			    		for(int k=0;k<NL;k++)
			    		{
			    			if(ORG[i-k].equals("0"))
			    				NIP[k]=0;
			    			if(ORG[i-k].equals("1"))
			    				NIP[k]=1;
			    			if(ORG[i-k].equals("2"))
			    				NIP[k]=2;
			    			if(ORG[i-k].equals("3"))
			    				NIP[k]=3;
			    			if(ORG[i-k].equals("4"))
			    				NIP[k]=4;
			    			if(ORG[i-k].equals("5"))
			    				NIP[k]=5;
			    			if(ORG[i-k].equals("6"))
			    				NIP[k]=6;
			    			if(ORG[i-k].equals("7"))
			    				NIP[k]=7;
			    			if(ORG[i-k].equals("8"))
			    				NIP[k]=8;
			    			if(ORG[i-k].equals("9"))
			    				NIP[k]=9;
			    		}
			    	}
			    	else
			    	{
			    		for(int k=0;k<NL-PD;k++)
			    		{
			    			if(ORG[i-k].equals("0"))
			    				NIP[k]=0;
			    			if(ORG[i-k].equals("1"))
			    				NIP[k]=1;
			    			if(ORG[i-k].equals("2"))
			    				NIP[k]=2;
			    			if(ORG[i-k].equals("3"))
			    				NIP[k]=3;
			    			if(ORG[i-k].equals("4"))
			    				NIP[k]=4;
			    			if(ORG[i-k].equals("5"))
			    				NIP[k]=5;
			    			if(ORG[i-k].equals("6"))
			    				NIP[k]=6;
			    			if(ORG[i-k].equals("7"))
			    				NIP[k]=7;
			    			if(ORG[i-k].equals("8"))
			    				NIP[k]=8;
			    			if(ORG[i-k].equals("9"))
			    				NIP[k]=9;
			    		}
			    		for(int k=NL-PD;k<NL;k++)
			    		{
			    			if(ORG[i-k-1].equals("0"))
			    				NIP[k]=0;
			    			if(ORG[i-k-1].equals("1"))
			    				NIP[k]=1;
			    			if(ORG[i-k-1].equals("2"))
			    				NIP[k]=2;
			    			if(ORG[i-k-1].equals("3"))
			    				NIP[k]=3;
			    			if(ORG[i-k-1].equals("4"))
			    				NIP[k]=4;
			    			if(ORG[i-k-1].equals("5"))
			    				NIP[k]=5;
			    			if(ORG[i-k-1].equals("6"))
			    				NIP[k]=6;
			    			if(ORG[i-k-1].equals("7"))
			    				NIP[k]=7;
			    			if(ORG[i-k-1].equals("8"))
			    				NIP[k]=8;
			    			if(ORG[i-k-1].equals("9"))
			    				NIP[k]=9;
			    		}
			    	}
			      	double TheNumber=0;
			    	//��ʾ�����
			      	if(PD==0)
			      	{
			      		for(int k=0; k<NL; k++)
			    				TheNumber+=NIP[k];
			      	}
			      	else
			      	{
			      		for(int k=0; k<NL; k++)
			    				TheNumber+=NIP[k]*Math.pow(10,k-NL+PD);
			      	}
	    			Numbers.add(TheNumber);
	    			//����Ϻõ�����������
	     			NL=0;
	     			PD=0;
	  	    		QN++;
	    			//��һ����������Ѿ���ɣ������ĳ��ȹ��㣬С�����λ��Ҳ���㣬��������+1
			    }
		    }
		}
		double[] result=new double[QN];
		for (int i=0; i<Numbers.size(); i++)
		//�����ִӶ�̬�����е�������̬����double[]
		{
			result[i]=Numbers.get(i);
		}
	    return result;
	}
    public static String[] BreakOperations (String[] ORG)
	{
	    int QO=0;
		//QO=Quantity of Operations
		//��ʾ��ʽ�������������
		ArrayList<String> OPR=new ArrayList<String>();
		//OPR=Operations
		//������ʱ���������
		/*
		boolean TFNA=false;
		//���ڸ���һ��������ȱʡ����
		//TFNA=The first number appears
		int TFNAA=0;
		//TFNAA=The first number appears at
		for (int i=0; TFNA=false; i++)
		{
		    if (!(ORG[i].equals("(")))
		    {
		   		TFNA=true;
	    		TFNAA=i;
	    	}
		}
		if (!(ORG[TFNAA].equals("+")||ORG[TFNAA].equals("-")))
		{
		    OPR.add("+");
		}
		*/
	    for (int i=0; i<ORG.length; i++)
	    
		//���ڽ��������������̬���鲢��¼������
		{
		    if(ORG[i].equals("+")||ORG[i].equals("-")||ORG[i].equals("*")||ORG[i].equals("/")||ORG[i].equals("^"))
		    {
		    	OPR.add(ORG[i]);
		    	QO++;
		    }
		}
		String[] result=new String[QO];
	    for (int i=0; i<OPR.size(); i++)
	    //�����ŴӶ�̬�����е�������̬����String[]
		{
			result[i]=(String) OPR.get(i);
		}
		return result;
	 }
	 public static int[] BreakOrders (String[] ORG)
	 {
	     ArrayList<Integer> ORD=new ArrayList<Integer>();
	     //������ʱ�������ȼ�
		 int NLP=0;
		 //NLP=number of left parenthesis
		 int NRP=0;
		 //NRP=number of right parenthesis
		 int CAL=0;
		 for (int i=0; i<ORG.length; i++)
		 {
			 NLP=0;
			 NRP=0;
		    for (int j=0; j<i; j++)
		    {
		    	if (ORG[j].equals("("))
		    	{
		    		NLP++;
		    	}
		    	if (ORG[j].equals(")"))
		    	{
		    		NRP++;
		    	}
		    	if (ORG[i].equals("+")||ORG[i].equals("-"))
		    	{
		    		CAL=0;
		    	}
		    	else if (ORG[i].equals("*")||ORG[i].equals("/"))
		    	{
		    		CAL=4;
		    	}
		    	else if (ORG[i].equals("^"))
		    	{
		    		CAL=8;
		    	}
		    }
		    if (ORG[i].equals("+")||ORG[i].equals("-")||ORG[i].equals("*")||ORG[i].equals("/")||ORG[i].equals("^"))
            {
	    		ORD.add((NLP-NRP)*100+CAL);
	    	}
		 }
	    	for (int i=0; i<ORD.size(); i++)
	    	{
	    		ArrayList<Integer> same=new ArrayList<Integer>();
	    		for (int j=0; j<ORD.size();j ++)
	    		{
	    			
	    			if (ORD.get(j).equals((Integer) ORD.get(i)))
	    			{
	    				same.add(j);
	    			}
	    		}
	    		int LTR=same.size();
	    		if (!(LTR==1))
	    		{
	    		for (int j=0; j<same.size();j++)
	    		{
	    			ORD.set((Integer) same.get(j),(Integer)ORD.get(j)+LTR);
	    			LTR--;
	    		}
	    		}
	    	}
		 int[] result=new int[ORD.size()];
		 for (int i=0; i<ORD.size(); i++)
		 //�����ȼ��Ӷ�̬�����е�������̬����int[]
		 {
			result[i]=(Integer) ORD.get(i);
		 }
		return result;
	    }
	 public static double Calculate (double[] SNUM, String[] SOPR, int[] SORD)
	    {
		ArrayList<Double> NUM=new ArrayList<Double>();
		ArrayList<String> OPR=new ArrayList<String>();
		ArrayList<Integer> ORD=new ArrayList<Integer>();
		for (int i=0; i<SNUM.length; i++)
		{
			NUM.add(SNUM[i]);
		}
		for (int i=0; i<SOPR.length; i++)
		{
			OPR.add(SOPR[i]);
		}
		for (int i=0; i<SORD.length; i++)
		{
			ORD.add(SORD[i]);
		}
		for (int i=100000; i>-10000; i--)
		{
			boolean Done=false;
			if (!(OPR.size()==0))
			{
			for (int j=0; Done==false; j++)
			{
                if (i==(Integer)ORD.get(j))
                {
            	    if (OPR.get(j).equals("+"))
            	    	NUM.set(j,NUM.get(j)+NUM.get(j+1));
                	if (OPR.get(j).equals("-"))
                  		NUM.set(j,NUM.get(j)-NUM.get(j+1));
                	if (OPR.get(j).equals("*"))
                 		NUM.set(j,NUM.get(j)*NUM.get(j+1));
                	if (OPR.get(j).equals("/"))
                		NUM.set(j,(NUM.get(j))/(NUM.get(j+1)));
                	if (OPR.get(j).equals("^"))
                		NUM.set(j,Math.pow(NUM.get(j),NUM.get(j+1)));
                NUM.remove(j+1);
                ORD.remove(j);
                OPR.remove(j);
                Done=true;
                }
                if (j==ORD.size()-1)
                	Done=true;
			}
		}
	}
	return NUM.get(0);
	}	 
}
