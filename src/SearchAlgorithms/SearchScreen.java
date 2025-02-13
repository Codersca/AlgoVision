package SearchAlgorithms;

import MenuScreens.Algorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchScreen implements ActionListener{
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final int win_WIDTH = 1000;

    public Color themeColor  = new Color(110,217,161);

    public int arraySize=0;
    public int numtofind = 0;

    JFrame f;
    JPanel panel, btnPanel;
    JLabel statusText, textboxText, comparisonText, speedText,sizeText,indexinputtext,dateinputtext;
    JButton startBtn, generateArrayBtn, bottomBtn,add;
    Search search;
    JComboBox<String> jComboBox;
    JTextField jTextField,size,indexInput,input;
    JLabel speedSlider;

    String[] algorithms = {
            "Linear Search",
            "Binary Search",
    };

    public String mainFont = "Century Gothic";

    public SearchScreen(){
        f = new JFrame("Searching Visualization");
        f.setSize(WIDTH, HEIGHT);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Will close when close BUTTON pressed
        f.setResizable(false);      //Resizing will destroy the ratio of grids

        search = new Search(arraySize);
        search.arrSize = arraySize;
        search.numtofind = numtofind;

        panel = new JPanel();
        panel.setBounds(0,0, win_WIDTH+10, HEIGHT);
        panel.setBackground(Color.darkGray);
        panel.setLayout(new GridLayout(1,100));        //Cols will be equal to max array size
        panel.setVisible(true);
        panel.addMouseWheelListener(this::mouseWheelMoved);

        sizeText = new JLabel("<html>Enter size of array:</html>");
        sizeText.setBounds(10, 30, 100, 30);
        sizeText.setFont(new Font(mainFont, Font.PLAIN, 12));
        sizeText.setForeground(Color.white);

        size = new JTextField(Integer.toString(arraySize));
        size.setBorder(BorderFactory.createLineBorder(Color.white));
        size.setBounds(120, 30, 90, 25);
        size.setBackground(new Color(102,102,102));
        size.setForeground(Color.white);
        size.setFont(new Font(mainFont, Font.BOLD, 12));
        size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });











int pos=120;
int targetindex=0,numtoact=0;
        indexinputtext = new JLabel("Enter Index: ");
        indexinputtext.setBounds(10, pos, 100, 30);
        indexinputtext.setFont(new Font(mainFont, Font.PLAIN, 12));
        indexinputtext.setForeground(Color.white);

        indexInput = new JTextField(Integer.toString(targetindex));
        indexInput.setBorder(BorderFactory.createLineBorder(Color.white));
        indexInput.setBounds(120, pos, 90, 25);
        indexInput.setBackground(new Color(102,102,102));
        indexInput.setForeground(Color.white);
        indexInput.setFont(new Font(mainFont, Font.BOLD, 15));
        pos+= 20;

        dateinputtext = new JLabel("Enter Value to add: ");
        dateinputtext.setBounds(10, pos, 100, 30);
        dateinputtext.setFont(new Font(mainFont, Font.PLAIN, 12));
        dateinputtext.setForeground(Color.white);

        input = new JTextField(Integer.toString(numtoact));
        input.setBorder(BorderFactory.createLineBorder(Color.white));
        input.setBounds(120, pos, 90, 25);
        input.setBackground(new Color(102,102,102));
        input.setForeground(Color.white);
        input.setFont(new Font(mainFont, Font.BOLD, 15));
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        pos+= 40;
        add = new JButton("Add to Array");
        add.setBounds(40, pos, 180,40);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int item = Integer.parseInt(input.getText());
                    int ind = Integer.parseInt(indexInput.getText());
                    search.adding(ind,item);
            }
        });
        add.setBackground(themeColor);
        add.setFont(new Font(mainFont, Font.BOLD, 15));
        add.setForeground(Color.white);
        add.setFocusable(false);
        add.setBorder(null);
        add.setVisible(true);
        //When the button is hovered
        add.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                if (add.isEnabled())
                    add.setBackground(themeColor.darker());
            }

            public void mouseExited(MouseEvent evt) {
                startBtn.setBackground(themeColor);
            }
        });






















        btnPanel = new JPanel();
        btnPanel.setBounds(win_WIDTH+10,0, WIDTH - 10 - win_WIDTH, HEIGHT);
        btnPanel.setBackground(search.BGColor.darker());
        btnPanel.setLayout(null);
        btnPanel.setVisible(true);
        btnPanel.addMouseWheelListener(this::mouseWheelMoved);

        textboxText = new JLabel("<html>search value:</html>");
        textboxText.setBounds(10, 220, 180, 60);
        textboxText.setFont(new Font(mainFont, Font.PLAIN, 12));
        textboxText.setForeground(Color.white);

        jTextField = new JTextField(Integer.toString(numtofind));
        jTextField.setBorder(BorderFactory.createLineBorder(Color.white));
        jTextField.setBounds(120, 230, 90, 25);
        jTextField.setBackground(new Color(102,102,102));
        jTextField.setForeground(Color.white);
        jTextField.setFont(new Font(mainFont, Font.BOLD, 20));
        jTextField.addActionListener(e -> {
            try{
                if (Integer.parseInt(jTextField.getText())>=0 && Integer.parseInt(jTextField.getText())<=99999){
                    numtofind = Integer.parseInt(jTextField.getText());
                    System.out.println(numtofind);
                    startBtn.setEnabled(true);
                    statusText.setText("Press Search");
                    comparisonText.setText("");
                }else{
                    throw new NumberFormatException("Invalid number");
                }
            }catch (NumberFormatException ne){
                System.out.println("Parbona");
                startBtn.setEnabled(false);
                statusText.setText("Invalid size format");
                comparisonText.setText("");
            }
        });



        generateArrayBtn = new JButton("Generate");
        generateArrayBtn.setBounds(40, 60, 180,50);
        generateArrayBtn.addActionListener(this);
        generateArrayBtn.setBackground(themeColor);
        generateArrayBtn.setFont(new Font(mainFont, Font.BOLD, 18));
        generateArrayBtn.setForeground(Color.white);
        generateArrayBtn.setFocusable(false);
        generateArrayBtn.setBorder(null);
        generateArrayBtn.setVisible(true);
        //When the button is hovered
        generateArrayBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                if (generateArrayBtn.isEnabled())
                    generateArrayBtn.setBackground(themeColor.darker());
            }

            public void mouseExited(MouseEvent evt) {
                generateArrayBtn.setBackground(themeColor);
            }
        });
        generateArrayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arraySize = Integer.parseInt(size.getText());
            }
        });

        startBtn = new JButton("Search");
        startBtn.setBounds(40, 260, 180,40);
        startBtn.addActionListener(this);
        startBtn.setBackground(themeColor);
        startBtn.setFont(new Font(mainFont, Font.BOLD, 18));
        startBtn.setForeground(Color.white);
        startBtn.setFocusable(false);
        startBtn.setBorder(null);
        startBtn.setVisible(true);
        //When the button is hovered
        startBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                if (startBtn.isEnabled())
                    startBtn.setBackground(themeColor.darker());
            }

            public void mouseExited(MouseEvent evt) {
                startBtn.setBackground(themeColor);
            }
        });

        jComboBox = new JComboBox<String>(algorithms);
        jComboBox.setBounds(40, 305, 180, 50);
        jComboBox.setFont(new Font(mainFont, Font.BOLD, 15));
        jComboBox.setBackground(themeColor);
        jComboBox.setForeground(Color.white);
        /*jComboBox.setBackground(Color.darkGray);
        //jComboBox.setForeground(new Color(110,217,161));
        jComboBox.setForeground(Color.white);*/
        //jComboBox.setUI(ColorArrowUI.createUI(jComboBox));
        jComboBox.setRenderer(new MyListCellsRenderer(themeColor));
        jComboBox.setSelectedIndex(0);
        jComboBox.setVisible(true);


        speedSlider = new JLabel("<html>Use the mouse scroll wheel to change the animation delay.<br>" +
                " Use the Ctrl or Shift keys along with the scroll wheel to change by bigger amount.</html>");
        speedSlider.setBounds(40, 350, 180, 150);
        speedSlider.setFont(new Font(mainFont, Font.PLAIN, 13));
        speedSlider.setForeground(Color.white);

        speedText = new JLabel( "Speed: " + search.animSpeed + " ms");
        speedText.setBounds(40, 480, 180, 50);
        speedText.setFont(new Font(mainFont, Font.PLAIN, 18));
        speedText.setForeground(Color.white);

        statusText = new JLabel("<html>Enter a number<br>and press search</html>");
        statusText.setBounds(40, 500, 280, 100);
        statusText.setFont(new Font(mainFont, Font.BOLD, 15));
        statusText.setForeground(Color.white);

        comparisonText = new JLabel("");
        comparisonText.setBounds(40, 580, 180, 50);
        comparisonText.setFont(new Font(mainFont, Font.PLAIN, 18));
        comparisonText.setForeground(Color.white);

        bottomBtn = new JButton("Back");
        bottomBtn.setBounds(40, 628, 180,50);
        bottomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //f.setVisible(false);
                f.dispose();
                new Algorithms();
                System.out.println("Came here");
            }
        });
        bottomBtn.setBackground(Color.darkGray.darker());
        bottomBtn.setFont(new Font(mainFont, Font.BOLD, 18));
        bottomBtn.setForeground(Color.white);
        bottomBtn.setFocusable(false);
        bottomBtn.setBorder(null);
        bottomBtn.setVisible(true);
        //When the button is hovered
        bottomBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                if (bottomBtn.isEnabled())
                    bottomBtn.setBackground(Color.darkGray.darker().darker());
            }

            public void mouseExited(MouseEvent evt) {
                bottomBtn.setBackground(Color.darkGray.darker());
            }
        });

        btnPanel.add(jTextField);
        btnPanel.add(generateArrayBtn);
        btnPanel.add(startBtn);
        btnPanel.add(jComboBox);
        btnPanel.add(statusText);
        btnPanel.add(textboxText);
        btnPanel.add(comparisonText);
        btnPanel.add(speedSlider);
        btnPanel.add(speedText);
        btnPanel.add(bottomBtn);
        btnPanel.add(sizeText);
        btnPanel.add(size);
        btnPanel.add(add);
        panel.add(search);

        btnPanel.add(indexInput);
        btnPanel.add(indexinputtext);
        btnPanel.add(dateinputtext);
        btnPanel.add(input);

        f.add(btnPanel);
        f.add(panel);

        f.setVisible(true);   //Visible






    }


    public static void main(String[] args) {
        SearchScreen ss = new SearchScreen();
    }


    //Mouse scroll event
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.isControlDown())
        {
            if (e.getWheelRotation() < 0) {
                search.animSpeed+= 100;
            } else {
                if (search.animSpeed - 100 >= 1)    search.animSpeed-= 100;
                else    search.animSpeed = 1;
            }
        }else if(e.isShiftDown()){
            if (e.getWheelRotation() < 0) {
                search.animSpeed+= 10;
            } else {
                if (search.animSpeed - 10 >= 1)    search.animSpeed-= 10;
                else    search.animSpeed = 1;
            }
        }else{
            if (e.getWheelRotation() < 0) {
                search.animSpeed+= 1;
            } else {
                if (search.animSpeed - 1 >= 1)    search.animSpeed-= 1;
            }
        }
        speedText.setText( "Speed: " + search.animSpeed + " ms");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //This part of the code is added so that the program will keep painting
        //even when the algorithm is called
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            public Void doInBackground() {
                // Call complicated code here
                generateArrayBtn.setEnabled(false);     //So that user can't press Generate during any operation
                jTextField.setEnabled(false);           //So that user can't use it during any operation

                /*if (jComboBox.getSelectedItem() == "Merge sort"){
                    speedText.setText( "Speed: " + sortarray.animSpeed*2 + " ms");
                }
                else*/
                speedText.setText( "Speed: " + search.animSpeed + " ms");

                if (e.getSource() == startBtn){
                    /*
                    Check if the program is sorting when the start/stop button is pressed.
                    If true, then stop the sorting by changing the boolean and change the button text
                    If false, then change status to sorting..., start the sorting algorithm code and change
                    button text to 'Stop'
                    */
                    if (search.isSearching){
                        startBtn.setText("Search");
                        statusText.setText("Stopped");
                        search.isSearching = false;

                        return null;
                    }else{
                        statusText.setText("Searching...");
                        startBtn.setText("Stop");
                        jComboBox.setEnabled(false);

                        numtofind = Integer.parseInt(jTextField.getText());
                        search.numtofind = numtofind;
                        statusText.setText("Searching " + numtofind + "...");

                        //Sort based on the dropdown menu selection
                        if (jComboBox.getSelectedItem() == "Linear Search"){
                            new SearchAlgorithms().LinearSearch(search);
                        }else if (jComboBox.getSelectedItem() == "Binary Search") {
                            new SearchAlgorithms().BinarySearch(search);
                        }
                    }
                }else if (e.getSource() == generateArrayBtn){
                    try{
                        if (Integer.parseInt(jTextField.getText())>=0 && Integer.parseInt(jTextField.getText())<=99999){
                            numtofind = Integer.parseInt(jTextField.getText());
                            //Generate new array
                            statusText.setText("Generating...");
                            startBtn.setEnabled(false);
                            search.GenerateRandomArray(arraySize);

                            statusText.setText("");
                            startBtn.setEnabled(true);
                            comparisonText.setText("");
                        }else{
                            throw new NumberFormatException("Invalid number");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Parbona");
                        startBtn.setEnabled(false);
                        statusText.setText("Invalid size format");
                        comparisonText.setText("");
                    }

                }
                return null;
                // If you want to return something other than null, change
                // the generic type to something other than Void.
                // This method's return value will be available via get() once the
                // operation has completed.
            }


            @Override
            protected void done() {
                // get() would be available here if you want to use it

                //After the operation is done, reenable the items again
                generateArrayBtn.setEnabled(true);
                jComboBox.setEnabled(true);
                jTextField.setEnabled(true);
                startBtn.setText("Search");
                search.isSearching = false;
                speedText.setText( "Speed: " + search.animSpeed + " ms");

                //Change the status text
                if (e.getSource() == startBtn){
                    if (search.IsFound){
                        statusText.setText("Found " + numtofind);
                        comparisonText.setText(search.comparisons + " comparisons");
                    }else{
                        statusText.setText(numtofind + " Not Found");
                    }
                }else if(e.getSource() == generateArrayBtn){
                    statusText.setText("Press search");
                    startBtn.setEnabled(true);
                }
            }
        };
        worker.execute();       //Keep executing the codes while operation is being performed

    }

}

//Custom dropdown menu settings
class MyListCellsRenderer extends DefaultListCellRenderer {
    public Color themeColor;

    public MyListCellsRenderer(Color t) {
        setOpaque(true);  //Not transparent
        this.themeColor = t;
    }

    public Component getListCellRendererComponent(JList jc, Object val, int idx,
                                                  boolean isSelected, boolean cellHasFocus) {
        setText(val.toString());        //Set the texts to string
        setForeground(Color.white);     //Text color to white
        jc.setSelectionBackground(themeColor);      //Sets the BG of selected item
        jc.setSelectionForeground(Color.white);     //Sets the font color of selected item

        if (isSelected)
            setBackground(themeColor);      //Sets the BG of hovered item
        else
            setBackground(Color.darkGray);      //Sets the BG of non hovered items
        return this;
    }
}