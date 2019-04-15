package UI_practice;



public class Arithmetic {
	static String num = "";
	public static void main(String[] args){
		//答题界面
		JFrame f=new JFrame();
		f.setTitle("四则混合运算");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		 
		//设置窗口的大小和位置
		f.setSize(400,400);
		f.setLocation(400,100);
		f.setLayout(null);
				
		Container con=f.getContentPane();//生成一个容器	
		con.setLayout(new GridLayout(2,1));
		
		//从UI界面接收本次出题的数量
		JPanel pan1=new JPanel();
		JLabel name1=new JLabel("请输入本次出题数量：");
		pan1.add(name1);
		JTextField nameTest1=new JTextField(15);
		nameTest1.setBounds(500, 100, 880, 100);
		//	nameTest2.setPreferredSize(new Dimension(180,100));
		pan1.add(nameTest1);
		pan1.setBounds( 100,500, 200, 120);
		con.add(pan1);
		
		JPanel pan2 = new JPanel();
		JButton b_log=new JButton("确定");
				
		b_log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 num = nameTest1.getText();
				 exercise();
			}
		});
		pan2.add(b_log);
		con.add(pan2);
	    //creatArith();//产生运算式
		//exercise();
	}
	//定义全局的分数
	static int score=0;
	//定义全局的value结果0
	static float currValue;
	//定义全局运算式的字符串
	static String currString;
	//定义全局时间
	static String currTime;
	//定义全局题目数
	static int currNums=0;
	/**1.在线答题界面**/
	public static void exercise(){
		JFrame f=new JFrame();
		f.setTitle("四则混合运算");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
	 
		//设置窗口的大小和位置
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
		JButton name2=new JButton("下一题");
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
		JButton btnStart=new JButton("开始");
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
				if(btnStart.getText().equals("开始")){
				currNums+=1;
				btnStart.setText("暂停");
				name1.setText(key);
				System.out.println("value:"+value);
				currValue=value;
				currString=key;
				map.clear();
				}else{
					btnStart.setText("开始");
					nameTest1.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e) {
						  //按回车键执行相应操作;
						if(e.getKeyChar()==KeyEvent.VK_ENTER ){
							String answerStr=nameTest1.getText();
							float answer=Float.parseFloat(answerStr);
							//判断正误，进行加分，并显示
							System.out.println("answer:"+answer);
							System.out.println("value:"+currValue);
							if(answer==currValue){
								score+=10;
								nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
								nameTest3.setText("本题为:"+currString+""+currValue+" ||  您的回答正确 || 当前分数:"+score);
								nameTest1.setText("");
							}else{
								nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
								nameTest3.setText("本题为:"+currString+""+currValue+" ||  您的回答错误 || 当前分数:"+score);
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
		JButton btnStart1=new JButton("计时");
		btnStart1.setBounds(30, 300,30, 30);
		btnStart1.setPreferredSize(new Dimension(100,80));
		btnStart1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnStart1.getText().equals("计时")){
				btnStart1.setText("正在计时...");
				nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
				nameTest3.setText("              计时开始，请认真答题");
				//获取当前时间
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
		JButton btnStart2=new JButton("结束");
		btnStart2.setBounds(30, 300,30, 30);
		btnStart2.setPreferredSize(new Dimension(100,80));
		btnStart2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//计算用时
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String endTime=df.format(new Date());
				try {
					long start =df.parse(currTime).getTime();
					long end=df.parse(endTime).getTime();
					int minutes = (int) ((end - start)/(1000 ));
					nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
					nameTest3.setText("时间:"+minutes+"秒  ||"+" 一共计算了"+currNums+"道题  ||  总得分:"+score);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		pan6.add(btnStart2);
		pan6.setBounds(340, 350, 110, 90);
		f.add(pan6);
		
	}
	
	//产生随机数
	public static int getNumber(){  
	        int number = 0;  
	        Random num = new Random();  
	        number = num.nextInt(100)+1;  
	        return number;  
	} 
	//随机产生运算符号
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
	
	//产生随机运算式
	static ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");
	public static Map<String,Integer> creatArith(){
		Map<String,Integer> map=new HashMap<String, Integer>();
		ArrayList<String> arithList = new ArrayList<String>();//运算式
		for(int i=0;arithList.size()!=Integer.parseInt(num);i++){
			
			String arr = "";
			for(int j=0;j<3;j++){
				int number = getNumber();
				String operator = String.valueOf(getOperator());
				arr += number + operator;
			}
			arr =arr.substring(0,arr.length()-1);
			//将arr转化为数组
			char[] arr_str = arr.toCharArray();
			String arrString = "";
			ArrayList<String> arrslist1 = new ArrayList<String>();
			ArrayList<String> arrslist2 = new ArrayList<String>();
			ArrayList<String> arrslist = new ArrayList<String>();
			//存储运算符
			for(int j=0;j<arr_str.length;j++) {
				if(arr_str[j]=='+'||arr_str[j]=='-'||arr_str[j]=='*'||arr_str[j]=='/') {	
					arrString=String.valueOf(arr_str[j]);
					arr_str[j]=',';
					arrslist1.add(arrString);
				}
			}
			//存储运算数
			String s = new String(arr_str);
			String[] ss = s.split(",");
			for(int k=0;k<ss.length;k++) {
				arrslist2.add(ss[k]);
			}
			//生成运算式
			String[] arrs1 = arrslist1.toArray(new String[arrslist1.size()]);//运算符
			String[] arrs2 = arrslist2.toArray(new String[arrslist2.size()]);//运算数
			
			for(int m=0;m<arrs1.length;m++){
				arrslist.add(arrs2[m]);//运算数
				arrslist.add(arrs1[m]);//运算符
			}
			arrslist.add(arrs2[arrs2.length-1]);
			String[] arrs = arrslist.toArray(new String[arrslist2.size()]);//运算式
			arr="";//初始化为空
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
			// 保证生成的运算式子的值在100以内
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
		//输出运算式
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
	//判断是否产生负数与小数
	public static void  check_arith(String arr[]){
		for(int i=0;i<arr.length;i++){
			//判断是否产生负数	
			if(arr[i].contains("-")){
				if(Integer.valueOf(arr[i-1])<Integer.valueOf(arr[i+1])){
					arr[i]="+";
				}
			}
			//判断是否产生小数
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
	//判断结果是否产生小数
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
	//存储运算式
	//封装目的地
	public static void filewriter(ArrayList<String> arithList) throws IOException {
		//封装存储位置
		BufferedWriter BufferedWriterbw = new BufferedWriter(new FileWriter("result.txt"));
		  BufferedWriterbw.newLine();
		  for(String s : arithList){
		        //写数据
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