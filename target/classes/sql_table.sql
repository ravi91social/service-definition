DROP TABLE IF EXISTS audit_details, service_definition, attribute_definition, service, attribute_value;

CREATE TABLE audit_details (
id SERIAL PRIMARY KEY,
created_by VARCHAR(255) NOT NULL,
last_modified_by VARCHAR(255),
created_time TIMESTAMP,
last_modified_time TIMESTAMP
);

CREATE TABLE service_definition (
id VARCHAR(255) NOT NULL UNIQUE,
tenant_id VARCHAR(255),
code VARCHAR(255),
is_active BOOLEAN,
audit_details_id INT,
additional_details JSON,
client_id varchar(255) NOT NULL,
CONSTRAINT fk_audit_details
      FOREIGN KEY(audit_details_id)
	  REFERENCES audit_details(id)
);

CREATE TABLE attribute_definition (
id VARCHAR(255) NOT NULL UNIQUE,
tenant_id VARCHAR(255) NOT NULL,
code VARCHAR(255),
data_type VARCHAR(255),
values TEXT[],
is_active BOOLEAN,
required BOOLEAN,
regEx VARCHAR(255),
"order" VARCHAR(255),
audit_details_id INT,
additional_details JSON,
service_definition_id VARCHAR(255),
CONSTRAINT fk_service_definition
      FOREIGN KEY(service_definition_id)
	  REFERENCES service_definition(id)
);


CREATE TABLE service (
id VARCHAR(255) NOT NULL UNIQUE,
tenant_id VARCHAR(255),
service_definition_id VARCHAR(255),
reference_id VARCHAR(255),
account_id VARCHAR(255),
client_id VARCHAR(255),
audit_details_id INT,
additional_details JSON,
CONSTRAINT fk_audit_details
      FOREIGN KEY(audit_details_id)
	  REFERENCES audit_details(id),
CONSTRAINT fk_service_definition
      FOREIGN KEY(service_definition_id)
	  REFERENCES service_definition(id)

);

CREATE TABLE attribute_value (
id VARCHAR(255) NOT NULL UNIQUE,
attribute_code VARCHAR(255),
value JSON,
audit_details_id INT,
additional_details JSON,
service_id VARCHAR(255),
CONSTRAINT fk_audit_details
      FOREIGN KEY(audit_details_id)
	  REFERENCES audit_details(id),
CONSTRAINT fk_service
    FOREIGN KEY(service_id)
  REFERENCES service(id)
);