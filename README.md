ทำด้วย Java Spring Boot (Maven)  

วิธีใช้งาน  
ลง Import spring_api_db.sql  

ลง Maven ให้เสร็จถ้าไม่มี  
https://maven.apache.org/download.cgi

bash: mvn spclean install  
bash: mvn spspring-boot:run

    // GET: ดึงข้อมูลสินค้าทั้งหมด
    // URL: GET /api/products

    // GET: ดึงข้อมูลสินค้าตาม ID
    // URL: GET /api/products/{id}

    // POST: สร้างสินค้าใหม่
    // URL: POST /api/products
    // Request Body: JSON ของ Product

    // PUT: อัปเดตสินค้าที่มีอยู่
    // URL: PUT /api/products/{id}
    // Request Body: JSON ของ Product ที่มีข้อมูลที่ต้องการอัปเดต

    // DELETE: ลบสินค้า
    // URL: DELETE /api/products/{id}
