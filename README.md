# flower-store-web-app
### Changes made and general information:

- Implemented InventoryManagement Subdomain --> requires verification but `docker-compose build` and `docker-compose up` are running fine.
- Implemented OrderProcessing Subdomain. Some warnings appeared that prevent from running `docker-compose build`. To review...
#### NOTE:
The Order entity seems different from the Product entity. It should be reviewed.

### Project description for ChatGPT:

The simple flower store web application, the domain-driven design (DDD) can be segmented into several subdomains, each handling a specific aspect of the flower store's operation. Below are the subdomains with explanations and examples of how they might be structured within the project. Keep in mind, the core domain is the primary focus of the business that provides competitive advantage, while supporting subdomains are necessary for the business to operate but are not the primary focus.
Core Domain: Product Management (Catalog)
Description: The Product Management (or Catalog) subdomain is central to a flower store, involving the management of flower inventory, categories, and product details. This includes information about flower types, arrangements, prices, descriptions, and images.
Examples:
•	Aggregate: Product Catalog
•	Entities: Product (Flower), Category
•	Value Objects: Price, Description
•	Aggregate Invariant: Each Product must have a unique identifier, belong to at least one Category, and have a non-negative price.
Supporting Subdomain: Order Management
Description: This subdomain handles everything related to processing customer orders, from creation to delivery. It includes managing order placement.
Examples:
•	Aggregate: Customer Order
•	Entities: Order, Order Item
•	Value Objects: Quantity, Shipping Address, Billing Information
•	Aggregate Invariant: An Order must contain at least one Order Item.
Supporting Subdomain: Inventory Management
Description: Inventory Management tracks the stock levels of flowers and related products, ensuring that the store can fulfill orders. It involves monitoring stock levels, managing suppliers, and reordering products.
Examples:
•	Aggregate: Stock Item
•	Entities: Product (Flower), Supplier
•	Value Objects: Stock Level, Reorder Threshold
•	Aggregate Invariant: The Stock Level of a Product must never fall below the Reorder Threshold without triggering a reorder.
Supporting Subdomain: Customer Management
Description: This subdomain focuses on managing customer information, including profiles, preferences, and history.
Examples:
•	Aggregate: Customer Profile
•	Entities: Customer, Order History
•	Value Objects: Customer ID, Contact Information
•	Aggregate Invariant: Each Customer must have a unique ID and Contact Information.
Aggregator Service: Flower Store Service
Description: The aggregator service, Flower Store Service, integrates the functionalities of the subdomains to provide a cohesive user experience. It facilitates interactions between the product catalog, order management, inventory management, and customer management services. This service acts as the glue that binds all the lower-level services, ensuring they work together seamlessly to fulfill business operations.
Examples:
•	Provides a unified API for accessing product catalogs, placing orders, checking inventory, and managing customer information.
•	Orchestrates operations between services, like updating inventory after an order is placed or updating customer order history.

The web service will be fully RESTful. This means that it must return HATEOAS links and following REST resource naming best practices. The web service will persistently store the resource it is managing in a database. The web service will support HTTP Request Methods: GET ALL, GET By ID, PUT, POST, and DELETE on all four sub-domains. The web service will support Request DTOs and Response DTOs on all endpoints where applicable. The web service will support ResponseEntity on all endpoints and will return appropriate HTTP statuses. The web service's aggregating subdomain will aggregate data from all three non-aggregating sub-domains. The web service will implement global exception handling, responding with appropriate HTTP status codes in case of success or error. The web service will be designed using 3-layer pattern. The web service will implement Mappers to convert to and from the Request and Response DTOs. For this project, it’s using Java with the Spring Boot framework. The project is already configured, I don’t need the configuration details. Don’t use the stream approach when working with mappers, instead use direct mapper calls.
