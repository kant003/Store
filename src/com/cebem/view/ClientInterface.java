package com.cebem.view;

/*
 * 
 * Clase que genera la GUI para la gestión de Clientes
 * 
 * */

import java.awt.BorderLayout;	
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cebem.controller.ClientManagement;
import com.cebem.model.Client;


public class ClientInterface {

	// VARIABLES
	private static JFrame frame;
	private JTable table;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtSurnames;
	private JTextField txtTelephone;
	private JTextField txtEmail;
	private JTextField txtAdress;
	private JTextField txtSearch;
	private JPasswordField txtPass;

	/**
	 * Lanza la aplicación
	 * 
	 * @param args String[] default
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					ClientInterface window = new ClientInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la aplicación
	 * 
	 */
	public ClientInterface() {
		initialize();
	}

	/**
	 * Inicializa el contenido del Frame
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setMinimumSize(frame.getSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelClientList = new JPanel();
		frame.getContentPane().add(panelClientList, "ClientList");
		panelClientList.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitleClientList = new JPanel();
		panelClientList.add(panelTitleClientList, BorderLayout.NORTH);
		panelTitleClientList.setLayout(new BorderLayout(0, 0));
		
		JLabel lblClientList = new JLabel("Listado de clientes");
		lblClientList.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelTitleClientList.add(lblClientList, BorderLayout.WEST);
		
		JPanel panelSearch = new JPanel();
		panelTitleClientList.add(panelSearch, BorderLayout.EAST);
		
		JLabel lblSearch = new JLabel("Buscar:");
		panelSearch.add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				search();
			}
		});
		txtSearch.setText("");
		panelSearch.add(txtSearch);
		txtSearch.setColumns(10);
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		panelClientList.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelButtonsClientList = new JPanel();
		panelClientList.add(panelButtonsClientList, BorderLayout.SOUTH);
		 
		JButton buttonDelete = new JButton("Borrar seleccionado");
		buttonDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				deleteClient();
			}
		});
		panelButtonsClientList.add(buttonDelete);
		
		JButton buttonEdit = new JButton("Editar seleccionado");
		buttonEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editClient();
			}
		});
		panelButtonsClientList.add(buttonEdit);
		
		JButton buttonAdd = new JButton("A\u00F1adir nuevo");
		buttonAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addClient();
			}
		});
		panelButtonsClientList.add(buttonAdd);
		
		JButton buttonRefresh = new JButton("Refrescar");
		buttonRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			}
		});
		panelButtonsClientList.add(buttonRefresh);
		
		JPanel panelClientEdit = new JPanel();
		frame.getContentPane().add(panelClientEdit, "ClientEdit");
		panelClientEdit.setLayout(new BorderLayout(0, 0));
		
		JPanel panelFieldsClientEdit = new JPanel();
		panelClientEdit.add(panelFieldsClientEdit, BorderLayout.CENTER);
		GridBagLayout gbl_panelFieldsClientEdit = new GridBagLayout();
		gbl_panelFieldsClientEdit.columnWidths = new int[]{216, 86, 0};
		gbl_panelFieldsClientEdit.rowHeights = new int[]{20, 20, 0, 0, 0, 0, 0, 0};
		gbl_panelFieldsClientEdit.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelFieldsClientEdit.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelFieldsClientEdit.setLayout(gbl_panelFieldsClientEdit);
		
		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panelFieldsClientEdit.add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		panelFieldsClientEdit.add(txtId, gbc_txtId);
		txtId.setText("");
		txtId.setColumns(10);
		
		JLabel lblName = new JLabel("Nombre");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		panelFieldsClientEdit.add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		panelFieldsClientEdit.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblSurnames = new JLabel("Apellidos");
		GridBagConstraints gbc_lblSurnames = new GridBagConstraints();
		gbc_lblSurnames.anchor = GridBagConstraints.EAST;
		gbc_lblSurnames.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurnames.gridx = 0;
		gbc_lblSurnames.gridy = 2;
		panelFieldsClientEdit.add(lblSurnames, gbc_lblSurnames);
		
		txtSurnames = new JTextField();
		GridBagConstraints gbc_txtSurnames = new GridBagConstraints();
		gbc_txtSurnames.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSurnames.insets = new Insets(0, 0, 5, 0);
		gbc_txtSurnames.gridx = 1;
		gbc_txtSurnames.gridy = 2;
		panelFieldsClientEdit.add(txtSurnames, gbc_txtSurnames);
		txtSurnames.setText("");
		txtSurnames.setColumns(10);
		
		JLabel lblTelephone = new JLabel("Tel\u00E9fono");
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.anchor = GridBagConstraints.EAST;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 3;
		panelFieldsClientEdit.add(lblTelephone, gbc_lblTelephone);
		
		txtTelephone = new JTextField();
		GridBagConstraints gbc_txtTelephone = new GridBagConstraints();
		gbc_txtTelephone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelephone.insets = new Insets(0, 0, 5, 0);
		gbc_txtTelephone.gridx = 1;
		gbc_txtTelephone.gridy = 3;
		panelFieldsClientEdit.add(txtTelephone, gbc_txtTelephone);
		txtTelephone.setText("");
		txtTelephone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		panelFieldsClientEdit.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 4;
		panelFieldsClientEdit.add(txtEmail, gbc_txtEmail);
		txtEmail.setText("");
		txtEmail.setColumns(10);
		
		JLabel lblAdress = new JLabel("Direcci\u00F3n");
		GridBagConstraints gbc_lblAdress = new GridBagConstraints();
		gbc_lblAdress.anchor = GridBagConstraints.EAST;
		gbc_lblAdress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdress.gridx = 0;
		gbc_lblAdress.gridy = 5;
		panelFieldsClientEdit.add(lblAdress, gbc_lblAdress);
		
		txtAdress = new JTextField();
		GridBagConstraints gbc_txtAdress = new GridBagConstraints();
		gbc_txtAdress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdress.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdress.gridx = 1;
		gbc_txtAdress.gridy = 5;
		panelFieldsClientEdit.add(txtAdress, gbc_txtAdress);
		txtAdress.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.anchor = GridBagConstraints.EAST;
		gbc_lblPass.insets = new Insets(0, 0, 0, 5);
		gbc_lblPass.gridx = 0;
		gbc_lblPass.gridy = 6;
		panelFieldsClientEdit.add(lblPass, gbc_lblPass);
		
		txtPass = new JPasswordField();
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPass.gridx = 1;
		gbc_txtPass.gridy = 6;
		panelFieldsClientEdit.add(txtPass, gbc_txtPass);
		
		JPanel panelTitleClientEdit = new JPanel();
		panelClientEdit.add(panelTitleClientEdit, BorderLayout.NORTH);
		
		JLabel lblTitleClientEdit = new JLabel("Edici\u00F3n de cliente");
		lblTitleClientEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelTitleClientEdit.add(lblTitleClientEdit);
		
		JPanel panelButtonsClientEdit = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtonsClientEdit.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelClientEdit.add(panelButtonsClientEdit, BorderLayout.SOUTH);
		
		JButton buttonSave = new JButton("Guardar");
		buttonSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveClient();
			}
		});
		panelButtonsClientEdit.add(buttonSave);
		
		JButton buttonCancel = new JButton("Cancelar");
		buttonCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cancelSave();
			}
		});
		panelButtonsClientEdit.add(buttonCancel);
	}


	private void deleteClient() {
		int row = table.getSelectedRow();
		int id = Integer.parseInt(table.getValueAt(row, 0).toString());

		
		ClientManagement.deleteClient(id);
	

		try {
			ClientManagement.openConnectionDB("User", "Ad1234");
			ClientManagement.deleteClient(id);
			ClientManagement.closeConnectionDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		refresh();

	}
	
	private void editClient(){
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "ClientEdit");
	}
	
	private void addClient(){
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "ClientEdit");
	}
	
	private void refresh(){
		try {
			ClientManagement.openConnectionDB("User", "Ad1234");
			ArrayList<Client> clients = ClientManagement.getClients();
			ClientManagement.closeConnectionDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveClient(){
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "ClientList");
	}
	
	private void cancelSave(){
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "ClientList");
	}
	
	private void search(){
		
	}
}
