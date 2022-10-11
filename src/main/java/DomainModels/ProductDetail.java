/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;
/**
 *
 * @author Nguyen Duy Hung
 */
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
@NamedQueries({
    @NamedQuery(name = "ProductDetail.FIND_ALL", query = "SELECT pd FROM ProductDetail pd"),
    @NamedQuery(name = "ProductDetail.FIND_BY_PRODUCT_CODE", query = "SELECT pd FROM ProductDetail pd WHERE pd.product.code = :code"),
    @NamedQuery(name = "ProductDetail.FIND_BY_ID", query = "SELECT pd FROM ProductDetail pd WHERE pd.id = :id")
})

@Entity
@Table(name = "ChiTietSP")
public class ProductDetail implements Serializable {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid")
    @GeneratedValue(generator = "generator")
    private String id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdSP")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private Color color;
    
    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private Category category;
    
    
    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private Manufacturer manufacturer;
    
    @Column(name = "NamBH")
    private int warrantyYear;
    
    @Column(name = "MoTa")
    private String decription;
    
    @Column(name = "SoLuongTon")
    private int quantity;
    
    @Column(name = "GiaNhap")
    private BigDecimal importPrice;
    
    @Column(name = "GiaBan")
    private BigDecimal price;

    public ProductDetail() {
    }

    public ProductDetail(String id, Product product, Color color, Category category, Manufacturer manufacturer, int warrantyYear, String decription,int quantity, BigDecimal importPrice, BigDecimal price) {
        this.id = id;
        this.product = product;
        this.color = color;
        this.category = category;
        this.manufacturer = manufacturer;
        this.warrantyYear = warrantyYear;
        this.decription = decription;
        this.importPrice = importPrice;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getWarrantyYear() {
        return warrantyYear;
    }

    public void setWarrantyYear(int warrantyYear) {
        this.warrantyYear = warrantyYear;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(BigDecimal importPrice) {
        this.importPrice = importPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}
