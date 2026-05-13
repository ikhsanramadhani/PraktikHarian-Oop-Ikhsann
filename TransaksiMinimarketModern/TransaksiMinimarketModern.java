package TransaksiMinimarketModern;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransaksiMinimarketModern extends JFrame {

    JTextField txtBarang, txtJumlah, txtHarga;
    JTextArea areaStruk;

    public TransaksiMinimarketModern() {
        setTitle("Transaksi Minimarket Modern");
        setSize(520, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                    0, 0, new Color(30, 64, 175),
                    0, getHeight(), new Color(14, 165, 233)
                );
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        background.setLayout(null);
        add(background);

        JLabel title = new JLabel("MINIMARKET");
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(150, 30, 250, 40);
        background.add(title);

        JLabel subtitle = new JLabel("Aplikasi Transaksi Pembelian");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitle.setForeground(new Color(230, 240, 255));
        subtitle.setBounds(155, 70, 250, 25);
        background.add(subtitle);

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBounds(55, 120, 400, 420);
        background.add(card);

        JLabel lblBarang = label("Nama Barang");
        lblBarang.setBounds(35, 25, 200, 25);
        card.add(lblBarang);

        txtBarang = input();
        txtBarang.setBounds(35, 52, 330, 40);
        card.add(txtBarang);

        JLabel lblJumlah = label("Jumlah Barang");
        lblJumlah.setBounds(35, 100, 200, 25);
        card.add(lblJumlah);

        txtJumlah = input();
        txtJumlah.setBounds(35, 127, 330, 40);
        card.add(txtJumlah);

        JLabel lblHarga = label("Harga Satuan");
        lblHarga.setBounds(35, 175, 200, 25);
        card.add(lblHarga);

        txtHarga = input();
        txtHarga.setBounds(35, 202, 330, 40);
        card.add(txtHarga);

        JButton btnHitung = new JButton("Hitung Transaksi");
        btnHitung.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnHitung.setForeground(Color.WHITE);
        btnHitung.setBackground(new Color(37, 99, 235));
        btnHitung.setFocusPainted(false);
        btnHitung.setBorderPainted(false);
        btnHitung.setBounds(35, 260, 330, 45);
        card.add(btnHitung);

        areaStruk = new JTextArea();
        areaStruk.setFont(new Font("Consolas", Font.PLAIN, 14));
        areaStruk.setEditable(false);
        areaStruk.setBackground(new Color(248, 250, 252));
        areaStruk.setText("===== STRUK TRANSAKSI =====\n\nBelum ada transaksi.");
        areaStruk.setBounds(35, 325, 330, 75);
        card.add(areaStruk);

        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hitungTransaksi();
            }
        });

        setVisible(true);
    }

    JLabel label(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lbl.setForeground(new Color(30, 41, 59));
        return lbl;
    }

    JTextField input() {
        JTextField txt = new JTextField();
        txt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txt.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(203, 213, 225)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return txt;
    }

    void hitungTransaksi() {
        try {
            String barang = txtBarang.getText();
            int jumlah = Integer.parseInt(txtJumlah.getText());
            int harga = Integer.parseInt(txtHarga.getText());
            int total = jumlah * harga;

            areaStruk.setText(
                "===== STRUK TRANSAKSI =====\n" +
                "Barang : " + barang + "\n" +
                "Jumlah : " + jumlah + "\n" +
                "Total  : Rp" + total
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Jumlah dan harga harus angka!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new TransaksiMinimarketModern();
    }
}