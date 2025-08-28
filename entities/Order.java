package sales.entities;

public class Order {
    private int id;
    private int customerId;
    private int employeeId;
    private String orderDate;

    public Order(){}

    public Order(String orderDate, int employeeId, int customerId, int id) {
        this.orderDate = orderDate;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Order ID: %-6d | Customer ID: %-6d | Employee ID: %-6d | Order Date: %-12s",
                id,
                customerId,
                employeeId,
                orderDate
        );
    }
}