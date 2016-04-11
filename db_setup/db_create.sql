/************ Update: Schemas ***************/

COMMENT ON SCHEMA public IS NULL;



/************ Add: Sequences ***************/

CREATE SEQUENCE public.seq_id INCREMENT BY 1;



/************ Update: Tables ***************/

/******************** Add Table: public.category ************************/

/* Build Table Structure */
CREATE TABLE public.category
(
	id BIGINT DEFAULT nextval('seq_id'::regclass) NOT NULL,
	name VARCHAR(200) NOT NULL,
	description TEXT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.category ADD CONSTRAINT pkcategory
	PRIMARY KEY (id);


/******************** Add Table: public.product ************************/

/* Build Table Structure */
CREATE TABLE public.product
(
	id BIGINT DEFAULT nextval('seq_id'::regclass) NOT NULL,
	name VARCHAR(250) NOT NULL,
	description TEXT NULL,
	producer VARCHAR(250) NULL,
	price NUMERIC(8, 2) NOT NULL,
	date_create TIMESTAMP NOT NULL,
	image BYTEA NULL,
	category_id BIGINT NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE public.product ADD CONSTRAINT pkproduct
	PRIMARY KEY (id);





/************ Add Foreign Keys ***************/

/* Add Foreign Key: fk_product_category */
ALTER TABLE public.product ADD CONSTRAINT fk_product_category
	FOREIGN KEY (category_id) REFERENCES public.category (id)
	ON UPDATE NO ACTION ON DELETE NO ACTION;