PGDMP         .                x           calculadoraip    12.1    12.1     ?
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24622    calculadoraip    DATABASE     ?   CREATE DATABASE calculadoraip WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_United States.1252' LC_CTYPE = 'Spanish_United States.1252';
    DROP DATABASE calculadoraip;
                postgres    false            ?            1259    24642    historialips    TABLE     ?  CREATE TABLE public.historialips (
    ip_historial character varying(15) NOT NULL,
    mascara_historial character varying(15) NOT NULL,
    tipo_historial character varying(7) NOT NULL,
    clase_historial character varying(7) NOT NULL,
    apipa_historial character varying(2) NOT NULL,
    reservada_historial character varying(10) NOT NULL,
    metodo_historial character varying(10) NOT NULL,
    red_historial character varying(15) NOT NULL,
    firstip_historial character varying(15) NOT NULL,
    lastip_historial character varying(15) NOT NULL,
    broadcast_historial character varying(15) NOT NULL,
    hosts_historial character varying(10) NOT NULL
);
     DROP TABLE public.historialips;
       public         heap    postgres    false            ?
          0    24642    historialips 
   TABLE DATA           ?   COPY public.historialips (ip_historial, mascara_historial, tipo_historial, clase_historial, apipa_historial, reservada_historial, metodo_historial, red_historial, firstip_historial, lastip_historial, broadcast_historial, hosts_historial) FROM stdin;
    public          postgres    false    202   >       ?
      x?????? ? ?     