import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ProductosGUI {

	private JFrame frame;
	private JTextField textSearch;
	private JTable table;
	private JTextField prodRef;
	private JTextField prodDes;
	private JTextField prodSupp;
	private JTextField prodStock;
	private JTextField prodPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductosGUI window = new ProductosGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProductosGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 624, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel_Listado = new JPanel();
		frame.getContentPane().add(panel_Listado, "name_934604148905097");
		panel_Listado.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_Listado.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblListadoDeProductos = new JLabel("Listado de Productos                         ");
		panel_1.add(lblListadoDeProductos);
		lblListadoDeProductos.setFont(new Font("Source Code Pro Black", Font.PLAIN, 15));
		
		JLabel lblBuscar = new JLabel("Buscar:");
		panel_1.add(lblBuscar);
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textSearch = new JTextField();
		panel_1.add(textSearch);
		textSearch.setColumns(15);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Listado.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_Listado.add(panel_2, BorderLayout.SOUTH);
		
		JButton deleteSelected = new JButton("Borrar Seleccionado");
		panel_2.add(deleteSelected);
		
		JButton editSelected = new JButton("Editar Seleccionado");
		panel_2.add(editSelected);
		
		JButton addNew = new JButton("A\u00F1adir Nuevo");
		panel_2.add(addNew);
		
		JButton refreshButton = new JButton("Refrescar");
		panel_2.add(refreshButton);
		
		JPanel panel_producto = new JPanel();
		frame.getContentPane().add(panel_producto, "name_934675842220639");
		panel_producto.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_producto.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblReferencia = new JLabel("Referencia");
		GridBagConstraints gbc_lblReferencia = new GridBagConstraints();
		gbc_lblReferencia.insets = new Insets(0, 0, 5, 5);
		gbc_lblReferencia.gridx = 2;
		gbc_lblReferencia.gridy = 1;
		panel_3.add(lblReferencia, gbc_lblReferencia);
		
		prodRef = new JTextField();
		GridBagConstraints gbc_prodRef = new GridBagConstraints();
		gbc_prodRef.insets = new Insets(0, 0, 5, 0);
		gbc_prodRef.fill = GridBagConstraints.HORIZONTAL;
		gbc_prodRef.gridx = 4;
		gbc_prodRef.gridy = 1;
		panel_3.add(prodRef, gbc_prodRef);
		prodRef.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 2;
		gbc_lblDescripcion.gridy = 3;
		panel_3.add(lblDescripcion, gbc_lblDescripcion);
		
		prodDes = new JTextField();
		GridBagConstraints gbc_prodDes = new GridBagConstraints();
		gbc_prodDes.insets = new Insets(0, 0, 5, 0);
		gbc_prodDes.fill = GridBagConstraints.HORIZONTAL;
		gbc_prodDes.gridx = 4;
		gbc_prodDes.gridy = 3;
		panel_3.add(prodDes, gbc_prodDes);
		prodDes.setColumns(10);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
		gbc_lblProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProveedor.gridx = 2;
		gbc_lblProveedor.gridy = 5;
		panel_3.add(lblProveedor, gbc_lblProveedor);
		
		prodSupp = new JTextField();
		GridBagConstraints gbc_prodSupp = new GridBagConstraints();
		gbc_prodSupp.insets = new Insets(0, 0, 5, 0);
		gbc_prodSupp.fill = GridBagConstraints.HORIZONTAL;
		gbc_prodSupp.gridx = 4;
		gbc_prodSupp.gridy = 5;
		panel_3.add(prodSupp, gbc_prodSupp);
		prodSupp.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock");
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.insets = new Insets(0, 0, 5, 5);
		gbc_lblStock.gridx = 2;
		gbc_lblStock.gridy = 7;
		panel_3.add(lblStock, gbc_lblStock);
		
		prodStock = new JTextField();
		GridBagConstraints gbc_prodStock = new GridBagConstraints();
		gbc_prodStock.insets = new Insets(0, 0, 5, 0);
		gbc_prodStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_prodStock.gridx = 4;
		gbc_prodStock.gridy = 7;
		panel_3.add(prodStock, gbc_prodStock);
		prodStock.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrecio.gridx = 2;
		gbc_lblPrecio.gridy = 9;
		panel_3.add(lblPrecio, gbc_lblPrecio);
		
		prodPrice = new JTextField();
		GridBagConstraints gbc_prodPrice = new GridBagConstraints();
		gbc_prodPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_prodPrice.gridx = 4;
		gbc_prodPrice.gridy = 9;
		panel_3.add(prodPrice, gbc_prodPrice);
		prodPrice.setColumns(10);
		
		JLabel lbltitle = new JLabel("Edici\u00F3n de Producto");
		lbltitle.setFont(new Font("Source Code Pro Black", Font.BOLD, 15));
		panel_producto.add(lbltitle, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_producto.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton prodSave = new JButton("Guardar");
		panel_4.add(prodSave);
		
		JButton prodCancel = new JButton("Cancelar");
		panel_4.add(prodCancel);
		editSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
