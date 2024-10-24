-- Insert data into the category table
INSERT INTO category (category_id, category_name, description)
VALUES
  (nextval('category_seq'), 'Electronics', 'Devices and gadgets'),
  (nextval('category_seq'), 'Furniture', 'Home and office furniture'),
  (nextval('category_seq'), 'Clothing', 'Apparel for men, women, and kids'),
  (nextval('category_seq'), 'Books', 'Printed and digital books'),
  (nextval('category_seq'), 'Toys', 'Toys for children of all ages'),
  (nextval('category_seq'), 'Kitchenware', 'Utensils and appliances for the kitchen'),
  (nextval('category_seq'), 'Sports', 'Sports equipment and apparel'),
  (nextval('category_seq'), 'Beauty', 'Cosmetics and skincare products'),
  (nextval('category_seq'), 'Automotive', 'Car parts and accessories'),
  (nextval('category_seq'), 'Garden', 'Outdoor and garden supplies');

-- Insert data into the product table
INSERT INTO product (product_id, product_name, description, available_quantity, price, category_id)
VALUES
  (nextval('product_seq'), 'Smartphone', 'Latest 5G smartphone', 100, 699.99,
      (SELECT category_id FROM category WHERE category_name = 'Electronics')),
  (nextval('product_seq'), 'Laptop', 'High-performance laptop', 50, 1199.99,
      (SELECT category_id FROM category WHERE category_name = 'Electronics')),
  (nextval('product_seq'), 'Dining Table', 'Modern dining table', 20, 299.99,
      (SELECT category_id FROM category WHERE category_name = 'Furniture')),
  (nextval('product_seq'), 'Sofa', 'Comfortable living room sofa', 10, 899.99,
      (SELECT category_id FROM category WHERE category_name = 'Furniture')),
  (nextval('product_seq'), 'Novel', 'Bestselling novel', 200, 14.99,
      (SELECT category_id FROM category WHERE category_name = 'Books')),
  (nextval('product_seq'), 'Action Figure', 'Superhero action figure', 150, 19.99,
      (SELECT category_id FROM category WHERE category_name = 'Toys')),
  (nextval('product_seq'), 'Blender', 'High-speed kitchen blender', 80, 99.99,
      (SELECT category_id FROM category WHERE category_name = 'Kitchenware')),
  (nextval('product_seq'), 'Tennis Racket', 'Professional-grade tennis racket', 30, 129.99,
      (SELECT category_id FROM category WHERE category_name = 'Sports')),
  (nextval('product_seq'), 'Lipstick', 'Long-lasting lipstick', 500, 9.99,
      (SELECT category_id FROM category WHERE category_name = 'Beauty')),
  (nextval('product_seq'), 'Car Tires', 'All-weather car tires', 40, 299.99,
      (SELECT category_id FROM category WHERE category_name = 'Automotive'));
