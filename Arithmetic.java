package UI_practice;



public class Arithmetic {
	static String num = "";
	public static void main(String[] args){
		//�������
		JFrame f=new JFrame();
		f.setTitle("����������");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		 
		//���ô��ڵĴ�С��λ��
		f.setSize(400,400);
		f.setLocation(400,100);
		f.setLayout(null);
				
		Container con=f.getContentPane();//����һ������	
		con.setLayout(new GridLayout(2,1));
		
		//��UI������ձ��γ��������
		JPanel pan1=new JPanel();
		JLabel name1=new JLabel("�����뱾�γ���������");
		pan1.add(name1);
		JTextField nameTest1=new JTextField(15);
		nameTest1.setBounds(500, 100, 880, 100);
		//	nameTest2.setPreferredSize(new Dimension(180,100));
		pan1.add(nameTest1);
		pan1.setBounds( 100,500, 200, 120);
		con.add(pan1);
		
		JPanel pan2 = new JPanel();
		JButton b_log=new JButton("ȷ��");
				
		b_log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 num = nameTest1.getText();
				 exercise();
			}
		});
		pan2.add(b_log);
		con.add(pan2);
	    //creatArith();//��������ʽ
		//exercise();
	}
	//����ȫ�ֵķ���
	static int score=0;
	//����ȫ�ֵ�value���0
	static float currValue;
	//����ȫ������ʽ���ַ���
	static String currString;
	//����ȫ��ʱ��
	static String currTime;
	//����ȫ����Ŀ��
	static int currNums=0;
	/**1.���ߴ������**/
	public static void exercise(){
		JFrame f=new JFrame();
		f.setTitle("����������");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
	 
		//���ô��ڵĴ�С��λ��
		f.setSize(600,500);
		f.setLocation(400,100);
		f.setLayout(null);
		
		JPanel pan1=new JPanel();
		JLabel name1=new JLabel("36/4+19=");
		pan1.add(name1);
		JTextField  nameTest1=new JTextField(15);
		nameTest1.setBounds(10, 10, 180, 100);
		//	nameTest1.setPreferredSize(new Dimension(180,100));
		pan1.add(nameTest1);
		pan1.setBounds(10, 10, 200, 120);
		f.add(pan1);
		
		JPanel pan2=new JPanel();
		JButton name2=new JButton("��һ��");
		pan2.add(name2);
		pan2.setBounds( 200,20, 200, 200);
		f.add(pan2);
		name2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 num = nameTest1.getText();
				 creatArith();
			}
		});
		pan2.add(name2);

		JPanel pan3=new JPanel();
		pan3.setLayout(null);
		JTextField nameTest3=new JTextField(15);
		nameTest3.setBounds(10, 60, 480, 200);
		nameTest3.setPreferredSize(new Dimension(300,100));
		pan3.add(nameTest3);
		pan3.setBounds( 10,60, 500, 220);
		f.add(pan3);
		
		JPanel pan4 = new JPanel();
//		pan4.setLayout(null);
		JButton btnStart=new JButton("��ʼ");
		btnStart.setBounds(30, 300,30, 30);
		btnStart.setPreferredSize(new Dimension(100,80));
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Map<String,Float> map=new HashMap<String,Float>();
				creatArith();
				Set set=map.keySet();
				Iterator iter = set.iterator();
				String key = (String) iter.next();  
				float value=map.get(key);
				if(btnStart.getText().equals("��ʼ")){
				currNums+=1;
				btnStart.setText("��ͣ");
				name1.setText(key);
				System.out.println("value:"+value);
				currValue=value;
				currString=key;
				map.clear();
				}else{
					btnStart.setText("��ʼ");
					nameTest1.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e) {
						  //���س���ִ����Ӧ����;
						if(e.getKeyChar()==KeyEvent.VK_ENTER ){
							String answerStr=nameTest1.getText();
							float answer=Float.parseFloat(answerStr);
							//�ж����󣬽��мӷ֣�����ʾ
							System.out.println("answer:"+answer);
							System.out.println("value:"+currValue);
							if(answer==currValue){
								score+=10;
								nameTest3.setFont(new Font("����", Font.PLAIN, 20));
								nameTest3.setText("����Ϊ:"+currString+""+currValue+" ||  ���Ļش���ȷ || ��ǰ����:"+score);
								nameTest1.setText("");
							}else{
								nameTest3.setFont(new Font("����", Font.PLAIN, 20));
								nameTest3.setText("����Ϊ:"+currString+""+currValue+" ||  ���Ļش���� || ��ǰ����:"+score);
							}
						} 
					};
					});
				}
			}
		});
		pan4.add(btnStart);
		pan4.setBounds(40, 350, 110, 90);
		f.add(pan4);
		
		/*JPanel pan5 = new JPanel();
//		pan4.setLayout(null);
		JButton btnStart1=new JButton("��ʱ");
		btnStart1.setBounds(30, 300,30, 30);
		btnStart1.setPreferredSize(new Dimension(100,80));
		btnStart1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnStart1.getText().equals("��ʱ")){
				btnStart1.setText("���ڼ�ʱ...");
				nameTest3.setFont(new Font("����", Font.PLAIN, 20));
				nameTest3.setText("              ��ʱ��ʼ�����������");
				//��ȡ��ǰʱ��
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				currTime=df.format(new Date());
				}
			}
		});
		pan5.add(btnStart1);
		pan5.setBounds(190, 350, 110, 90);
		f.add(pan5);*/
		
		JPanel pan6 = new JPanel();
//		pan4.setLayout(null);
		JButton btnStart2=new JButton("����");
		btnStart2.setBounds(30, 300,30, 30);
		btnStart2.setPreferredSize(new Dimension(100,80));
		btnStart2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//������ʱ
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String endTime=df.format(new Date());
				try {
					long start =df.parse(currTime).getTime();
					long end=df.parse(endTime).getTime();
					int minutes = (int) ((end - start)/(1000 ));
					nameTest3.setFont(new Font("����", Font.PLAIN, 20));
					nameTest3.setText("ʱ��:"+minutes+"��  ||"+" һ��������"+currNums+"����  ||  �ܵ÷�:"+score);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		pan6.add(btnStart2);
		pan6.setBounds(340, 350, 110, 90);
		f.add(pan6);
		
	}
	
	//���������
	public static int getNumber(){  
	        int number = 0;  
	        Random num = new Random();  
	        number = num.nextInt(100)+1;  
	        return number;  
	} 
	//��������������
	public static char getOperator(){  
        char operator = 0;  
        Random ran = new Random();  
        int i = ran.nextInt(4);  
        switch(i){  
            case 0:  
                operator = '+';  
                break;  
            case 1:  
                operator = '-';  
                break;  
            case 2:  
                operator = '*';  
                break;  
            case 3:  
                operator = '/';  
                break;  
        }  
        return operator;  
     } 
	
	//�����������ʽ
	static ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");
	public static Map<String,Integer> creatArith(){
		Map<String,Integer> map=new HashMap<String, Integer>();
		ArrayList<String> arithList = new ArrayList<String>();//����ʽ
		for(int i=0;arithList.size()!=Integer.parseInt(num);i++){
			
			String arr = "";
			for(int j=0;j<3;j++){
				int number = getNumber();
				String operator = String.valueOf(getOperator());
				arr += number + operator;
			}
			arr =arr.substring(0,arr.length()-1);
			//��arrת��Ϊ����
			char[] arr_str = arr.toCharArray();
			String arrString = "";
			ArrayList<String> arrslist1 = new ArrayList<String>();
			ArrayList<String> arrslist2 = new ArrayList<String>();
			ArrayList<String> arrslist = new ArrayList<String>();
			//�洢�����
			for(int j=0;j<arr_str.length;j++) {
				if(arr_str[j]=='+'||arr_str[j]=='-'||arr_str[j]=='*'||arr_str[j]=='/') {	
					arrString=String.valueOf(arr_str[j]);
					arr_str[j]=',';
					arrslist1.add(arrString);
				}
			}
			//�洢������
			String s = new String(arr_str);
			String[] ss = s.split(",");
			for(int k=0;k<ss.length;k++) {
				arrslist2.add(ss[k]);
			}
			//��������ʽ
			String[] arrs1 = arrslist1.toArray(new String[arrslist1.size()]);//�����
			String[] arrs2 = arrslist2.toArray(new String[arrslist2.size()]);//������
			
			for(int m=0;m<arrs1.length;m++){
				arrslist.add(arrs2[m]);//������
				arrslist.add(arrs1[m]);//�����
			}
			arrslist.add(arrs2[arrs2.length-1]);
			String[] arrs = arrslist.toArray(new String[arrslist2.size()]);//����ʽ
			arr="";//��ʼ��Ϊ��
			check_arith(arrs);
			for(int t=0;t<arrs.length;t++) {
				arr+=arrs[t];
			}
			try {
				check_arith_question(arrs,arr);
			} catch (ScriptException e) {
				e.printStackTrace();
			}
			arr="";
			for(int t=0;t<arrs.length;t++) {
				arr+=arrs[t];
			}
			// ��֤���ɵ�����ʽ�ӵ�ֵ��100����
			try {
				int result = (int)(js.eval(arr));
				if(result >= 0 && result <= 100) {
					arithList.add(arr);
				}
				
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//�������ʽ
		for(String arr: arithList){
			try {
				int result = (int)(js.eval(arr));
				map.put(arr, result);
			} catch (ScriptException e) {
				e.printStackTrace();
			} 	
		}
		try {
			filewriter(arithList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	//�ж��Ƿ����������С��
	public static void  check_arith(String arr[]){
		for(int i=0;i<arr.length;i++){
			//�ж��Ƿ��������	
			if(arr[i].contains("-")){
				if(Integer.valueOf(arr[i-1])<Integer.valueOf(arr[i+1])){
					arr[i]="+";
				}
			}
			//�ж��Ƿ����С��
			if(arr[i].contains("/")){
				int a = Integer.valueOf(arr[i-1]);
				int b = Integer.valueOf(arr[i+1]);
					int x = a%b;
					if(x!=0){
						arr[i]="+";
					}
				}
		}
	}
	//�жϽ���Ƿ����С��
	public static void  check_arith_question(String arr[],String arrString) throws ScriptException{
			for(int i=0;i<arr.length;i++){
				String str = js.eval(arrString).toString();
				if(Integer.valueOf(str)<0) {
					if(arr[i].contains("-")){
						arr[i]="+";
					}
				}
			}
	}
	//�洢����ʽ
	//��װĿ�ĵ�
	public static void filewriter(ArrayList<String> arithList) throws IOException {
		//��װ�洢λ��
		BufferedWriter BufferedWriterbw = new BufferedWriter(new FileWriter("result.txt"));
		  BufferedWriterbw.newLine();
		  for(String s : arithList){
		        //д����
			  try {
				BufferedWriterbw.write(s+"="+js.eval(s));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
			  BufferedWriterbw.newLine();
			  BufferedWriterbw.flush();
		  }
	}
    
}