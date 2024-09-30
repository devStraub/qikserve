PGDMP      (                |            postgres    16.3    16.3 F    ^           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            _           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            `           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            a           1262    5    postgres    DATABASE        CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE postgres;
                postgres    false            b           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    6241                        2615    107737    qikserve    SCHEMA        CREATE SCHEMA qikserve;
    DROP SCHEMA qikserve;
                postgres    false            .           1259    107800    client    TABLE     �   CREATE TABLE qikserve.client (
    id bigint NOT NULL,
    name character varying,
    document character varying NOT NULL,
    birth timestamp without time zone
);
    DROP TABLE qikserve.client;
       qikserve         heap    postgres    false    31            -           1259    107799    client_id_seq    SEQUENCE     x   CREATE SEQUENCE qikserve.client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE qikserve.client_id_seq;
       qikserve          postgres    false    31    814            c           0    0    client_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE qikserve.client_id_seq OWNED BY qikserve.client.id;
          qikserve          postgres    false    813            (           1259    107748 
   group_item    TABLE     Y   CREATE TABLE qikserve.group_item (
    id bigint NOT NULL,
    name character varying
);
     DROP TABLE qikserve.group_item;
       qikserve         heap    postgres    false    31            '           1259    107747    group_item_id_seq    SEQUENCE     |   CREATE SEQUENCE qikserve.group_item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE qikserve.group_item_id_seq;
       qikserve          postgres    false    31    808            d           0    0    group_item_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE qikserve.group_item_id_seq OWNED BY qikserve.group_item.id;
          qikserve          postgres    false    807            &           1259    107739    item    TABLE     �   CREATE TABLE qikserve.item (
    id bigint NOT NULL,
    name character varying,
    price numeric,
    group_item bigint,
    provider_id character varying
);
    DROP TABLE qikserve.item;
       qikserve         heap    postgres    false    31            %           1259    107738    newtable_id_seq    SEQUENCE     z   CREATE SEQUENCE qikserve.newtable_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE qikserve.newtable_id_seq;
       qikserve          postgres    false    31    806            e           0    0    newtable_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE qikserve.newtable_id_seq OWNED BY qikserve.item.id;
          qikserve          postgres    false    805            2           1259    107828    order    TABLE     �   CREATE TABLE qikserve."order" (
    id bigint NOT NULL,
    client bigint NOT NULL,
    date timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);
    DROP TABLE qikserve."order";
       qikserve         heap    postgres    false    31            1           1259    107827    order_id_seq    SEQUENCE     w   CREATE SEQUENCE qikserve.order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE qikserve.order_id_seq;
       qikserve          postgres    false    818    31            f           0    0    order_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE qikserve.order_id_seq OWNED BY qikserve."order".id;
          qikserve          postgres    false    817            4           1259    107836 
   order_item    TABLE       CREATE TABLE qikserve.order_item (
    id bigint NOT NULL,
    "order" bigint NOT NULL,
    item bigint NOT NULL,
    unit_cost numeric NOT NULL,
    unit_discont numeric DEFAULT 0,
    amount integer DEFAULT 1 NOT NULL,
    total_paid numeric DEFAULT 0
);
     DROP TABLE qikserve.order_item;
       qikserve         heap    postgres    false    31            3           1259    107835    order_item_id_seq    SEQUENCE     |   CREATE SEQUENCE qikserve.order_item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE qikserve.order_item_id_seq;
       qikserve          postgres    false    31    820            g           0    0    order_item_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE qikserve.order_item_id_seq OWNED BY qikserve.order_item.id;
          qikserve          postgres    false    819            *           1259    107768 	   promotion    TABLE     �   CREATE TABLE qikserve.promotion (
    id bigint NOT NULL,
    name character varying,
    date_start timestamp without time zone,
    date_end timestamp without time zone,
    active boolean DEFAULT false NOT NULL,
    type bigint NOT NULL
);
    DROP TABLE qikserve.promotion;
       qikserve         heap    postgres    false    31            )           1259    107767    promotion_id_seq    SEQUENCE     {   CREATE SEQUENCE qikserve.promotion_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE qikserve.promotion_id_seq;
       qikserve          postgres    false    31    810            h           0    0    promotion_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE qikserve.promotion_id_seq OWNED BY qikserve.promotion.id;
          qikserve          postgres    false    809            ,           1259    107778    promotion_relation    TABLE     �   CREATE TABLE qikserve.promotion_relation (
    id bigint NOT NULL,
    promotion bigint NOT NULL,
    item bigint,
    group_item bigint,
    client bigint
);
 (   DROP TABLE qikserve.promotion_relation;
       qikserve         heap    postgres    false    31            +           1259    107777    promotion_relation_id_seq    SEQUENCE     �   CREATE SEQUENCE qikserve.promotion_relation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE qikserve.promotion_relation_id_seq;
       qikserve          postgres    false    31    812            i           0    0    promotion_relation_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE qikserve.promotion_relation_id_seq OWNED BY qikserve.promotion_relation.id;
          qikserve          postgres    false    811            0           1259    107814    promotion_type    TABLE     f   CREATE TABLE qikserve.promotion_type (
    id bigint NOT NULL,
    name character varying NOT NULL
);
 $   DROP TABLE qikserve.promotion_type;
       qikserve         heap    postgres    false    31            /           1259    107813    promotion_type_id_seq    SEQUENCE     �   CREATE SEQUENCE qikserve.promotion_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE qikserve.promotion_type_id_seq;
       qikserve          postgres    false    816    31            j           0    0    promotion_type_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE qikserve.promotion_type_id_seq OWNED BY qikserve.promotion_type.id;
          qikserve          postgres    false    815            �           2604    107803 	   client id    DEFAULT     j   ALTER TABLE ONLY qikserve.client ALTER COLUMN id SET DEFAULT nextval('qikserve.client_id_seq'::regclass);
 :   ALTER TABLE qikserve.client ALTER COLUMN id DROP DEFAULT;
       qikserve          postgres    false    814    813    814            �           2604    107751    group_item id    DEFAULT     r   ALTER TABLE ONLY qikserve.group_item ALTER COLUMN id SET DEFAULT nextval('qikserve.group_item_id_seq'::regclass);
 >   ALTER TABLE qikserve.group_item ALTER COLUMN id DROP DEFAULT;
       qikserve          postgres    false    807    808    808            �           2604    107742    item id    DEFAULT     j   ALTER TABLE ONLY qikserve.item ALTER COLUMN id SET DEFAULT nextval('qikserve.newtable_id_seq'::regclass);
 8   ALTER TABLE qikserve.item ALTER COLUMN id DROP DEFAULT;
       qikserve          postgres    false    806    805    806            �           2604    107831    order id    DEFAULT     j   ALTER TABLE ONLY qikserve."order" ALTER COLUMN id SET DEFAULT nextval('qikserve.order_id_seq'::regclass);
 ;   ALTER TABLE qikserve."order" ALTER COLUMN id DROP DEFAULT;
       qikserve          postgres    false    817    818    818            �           2604    107839    order_item id    DEFAULT     r   ALTER TABLE ONLY qikserve.order_item ALTER COLUMN id SET DEFAULT nextval('qikserve.order_item_id_seq'::regclass);
 >   ALTER TABLE qikserve.order_item ALTER COLUMN id DROP DEFAULT;
       qikserve          postgres    false    819    820    820            �           2604    107771    promotion id    DEFAULT     p   ALTER TABLE ONLY qikserve.promotion ALTER COLUMN id SET DEFAULT nextval('qikserve.promotion_id_seq'::regclass);
 =   ALTER TABLE qikserve.promotion ALTER COLUMN id DROP DEFAULT;
       qikserve          postgres    false    809    810    810            �           2604    107781    promotion_relation id    DEFAULT     �   ALTER TABLE ONLY qikserve.promotion_relation ALTER COLUMN id SET DEFAULT nextval('qikserve.promotion_relation_id_seq'::regclass);
 F   ALTER TABLE qikserve.promotion_relation ALTER COLUMN id DROP DEFAULT;
       qikserve          postgres    false    812    811    812            �           2604    107817    promotion_type id    DEFAULT     z   ALTER TABLE ONLY qikserve.promotion_type ALTER COLUMN id SET DEFAULT nextval('qikserve.promotion_type_id_seq'::regclass);
 B   ALTER TABLE qikserve.promotion_type ALTER COLUMN id DROP DEFAULT;
       qikserve          postgres    false    815    816    816            U          0    107800    client 
   TABLE DATA           =   COPY qikserve.client (id, name, document, birth) FROM stdin;
    qikserve          postgres    false    814   �O       O          0    107748 
   group_item 
   TABLE DATA           0   COPY qikserve.group_item (id, name) FROM stdin;
    qikserve          postgres    false    808   
P       M          0    107739    item 
   TABLE DATA           J   COPY qikserve.item (id, name, price, group_item, provider_id) FROM stdin;
    qikserve          postgres    false    806   'P       Y          0    107828    order 
   TABLE DATA           5   COPY qikserve."order" (id, client, date) FROM stdin;
    qikserve          postgres    false    818   DP       [          0    107836 
   order_item 
   TABLE DATA           f   COPY qikserve.order_item (id, "order", item, unit_cost, unit_discont, amount, total_paid) FROM stdin;
    qikserve          postgres    false    820   aP       Q          0    107768 	   promotion 
   TABLE DATA           S   COPY qikserve.promotion (id, name, date_start, date_end, active, type) FROM stdin;
    qikserve          postgres    false    810   ~P       S          0    107778    promotion_relation 
   TABLE DATA           W   COPY qikserve.promotion_relation (id, promotion, item, group_item, client) FROM stdin;
    qikserve          postgres    false    812   �P       W          0    107814    promotion_type 
   TABLE DATA           4   COPY qikserve.promotion_type (id, name) FROM stdin;
    qikserve          postgres    false    816   �P       k           0    0    client_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('qikserve.client_id_seq', 1, false);
          qikserve          postgres    false    813            l           0    0    group_item_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('qikserve.group_item_id_seq', 1, false);
          qikserve          postgres    false    807            m           0    0    newtable_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('qikserve.newtable_id_seq', 1, false);
          qikserve          postgres    false    805            n           0    0    order_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('qikserve.order_id_seq', 1, false);
          qikserve          postgres    false    817            o           0    0    order_item_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('qikserve.order_item_id_seq', 1, false);
          qikserve          postgres    false    819            p           0    0    promotion_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('qikserve.promotion_id_seq', 1, false);
          qikserve          postgres    false    809            q           0    0    promotion_relation_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('qikserve.promotion_relation_id_seq', 1, false);
          qikserve          postgres    false    811            r           0    0    promotion_type_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('qikserve.promotion_type_id_seq', 1, false);
          qikserve          postgres    false    815            �           2606    107807    client client_pk 
   CONSTRAINT     P   ALTER TABLE ONLY qikserve.client
    ADD CONSTRAINT client_pk PRIMARY KEY (id);
 <   ALTER TABLE ONLY qikserve.client DROP CONSTRAINT client_pk;
       qikserve            postgres    false    814            �           2606    107755    group_item group_item_pk 
   CONSTRAINT     X   ALTER TABLE ONLY qikserve.group_item
    ADD CONSTRAINT group_item_pk PRIMARY KEY (id);
 D   ALTER TABLE ONLY qikserve.group_item DROP CONSTRAINT group_item_pk;
       qikserve            postgres    false    808            �           2606    107746    item item_pk 
   CONSTRAINT     L   ALTER TABLE ONLY qikserve.item
    ADD CONSTRAINT item_pk PRIMARY KEY (id);
 8   ALTER TABLE ONLY qikserve.item DROP CONSTRAINT item_pk;
       qikserve            postgres    false    806            �           2606    107844    order_item order_item_pk 
   CONSTRAINT     X   ALTER TABLE ONLY qikserve.order_item
    ADD CONSTRAINT order_item_pk PRIMARY KEY (id);
 D   ALTER TABLE ONLY qikserve.order_item DROP CONSTRAINT order_item_pk;
       qikserve            postgres    false    820            �           2606    107834    order order_pk 
   CONSTRAINT     P   ALTER TABLE ONLY qikserve."order"
    ADD CONSTRAINT order_pk PRIMARY KEY (id);
 <   ALTER TABLE ONLY qikserve."order" DROP CONSTRAINT order_pk;
       qikserve            postgres    false    818            �           2606    107776    promotion promotion_pk 
   CONSTRAINT     V   ALTER TABLE ONLY qikserve.promotion
    ADD CONSTRAINT promotion_pk PRIMARY KEY (id);
 B   ALTER TABLE ONLY qikserve.promotion DROP CONSTRAINT promotion_pk;
       qikserve            postgres    false    810            �           2606    107783 (   promotion_relation promotion_relation_pk 
   CONSTRAINT     h   ALTER TABLE ONLY qikserve.promotion_relation
    ADD CONSTRAINT promotion_relation_pk PRIMARY KEY (id);
 T   ALTER TABLE ONLY qikserve.promotion_relation DROP CONSTRAINT promotion_relation_pk;
       qikserve            postgres    false    812            �           2606    107821     promotion_type promotion_type_pk 
   CONSTRAINT     `   ALTER TABLE ONLY qikserve.promotion_type
    ADD CONSTRAINT promotion_type_pk PRIMARY KEY (id);
 L   ALTER TABLE ONLY qikserve.promotion_type DROP CONSTRAINT promotion_type_pk;
       qikserve            postgres    false    816            �           2606    107762    item item_group_item_fk    FK CONSTRAINT     �   ALTER TABLE ONLY qikserve.item
    ADD CONSTRAINT item_group_item_fk FOREIGN KEY (group_item) REFERENCES qikserve.group_item(id) ON DELETE RESTRICT;
 C   ALTER TABLE ONLY qikserve.item DROP CONSTRAINT item_group_item_fk;
       qikserve          postgres    false    6039    808    806            �           2606    107845    order_item order_item_item_fk    FK CONSTRAINT     |   ALTER TABLE ONLY qikserve.order_item
    ADD CONSTRAINT order_item_item_fk FOREIGN KEY (item) REFERENCES qikserve.item(id);
 I   ALTER TABLE ONLY qikserve.order_item DROP CONSTRAINT order_item_item_fk;
       qikserve          postgres    false    6037    806    820            �           2606    107850    order_item order_item_order_fk    FK CONSTRAINT     �   ALTER TABLE ONLY qikserve.order_item
    ADD CONSTRAINT order_item_order_fk FOREIGN KEY ("order") REFERENCES qikserve."order"(id);
 J   ALTER TABLE ONLY qikserve.order_item DROP CONSTRAINT order_item_order_fk;
       qikserve          postgres    false    818    820    6049            �           2606    107822 %   promotion promotion_promotion_type_fk    FK CONSTRAINT     �   ALTER TABLE ONLY qikserve.promotion
    ADD CONSTRAINT promotion_promotion_type_fk FOREIGN KEY (type) REFERENCES qikserve.promotion_type(id);
 Q   ALTER TABLE ONLY qikserve.promotion DROP CONSTRAINT promotion_promotion_type_fk;
       qikserve          postgres    false    816    810    6047            �           2606    107808 /   promotion_relation promotion_relation_client_fk    FK CONSTRAINT     �   ALTER TABLE ONLY qikserve.promotion_relation
    ADD CONSTRAINT promotion_relation_client_fk FOREIGN KEY (client) REFERENCES qikserve.client(id);
 [   ALTER TABLE ONLY qikserve.promotion_relation DROP CONSTRAINT promotion_relation_client_fk;
       qikserve          postgres    false    6045    814    812            �           2606    107789 3   promotion_relation promotion_relation_group_item_fk    FK CONSTRAINT     �   ALTER TABLE ONLY qikserve.promotion_relation
    ADD CONSTRAINT promotion_relation_group_item_fk FOREIGN KEY (group_item) REFERENCES qikserve.group_item(id);
 _   ALTER TABLE ONLY qikserve.promotion_relation DROP CONSTRAINT promotion_relation_group_item_fk;
       qikserve          postgres    false    808    6039    812            �           2606    107784 -   promotion_relation promotion_relation_item_fk    FK CONSTRAINT     �   ALTER TABLE ONLY qikserve.promotion_relation
    ADD CONSTRAINT promotion_relation_item_fk FOREIGN KEY (item) REFERENCES qikserve.item(id);
 Y   ALTER TABLE ONLY qikserve.promotion_relation DROP CONSTRAINT promotion_relation_item_fk;
       qikserve          postgres    false    806    812    6037            �           2606    107794 2   promotion_relation promotion_relation_promotion_fk    FK CONSTRAINT     �   ALTER TABLE ONLY qikserve.promotion_relation
    ADD CONSTRAINT promotion_relation_promotion_fk FOREIGN KEY (promotion) REFERENCES qikserve.promotion(id);
 ^   ALTER TABLE ONLY qikserve.promotion_relation DROP CONSTRAINT promotion_relation_promotion_fk;
       qikserve          postgres    false    810    812    6041            U      x������ � �      O      x������ � �      M      x������ � �      Y      x������ � �      [      x������ � �      Q      x������ � �      S      x������ � �      W      x������ � �     