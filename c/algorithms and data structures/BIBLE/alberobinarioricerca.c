/**************************/
/*ALBERI BINARI DI RICERCA*/
/**************************/

/*NOTA BENE
sono alberi binari che seguono questa proprietà: il figlio destro di un nodo 
è più grande di suo padre, il figlio sinistro di un nodo è più piccolo di 
suo padre*/

/*VISITA INORDER*/
void bit_inorder(Bit_node p){
    if(p){
        bit_inorder(p->l);
        bit_printnode(p);
        bit_inorder(p->r);
    }
}

/*VISITA PREORDER*/
void bit_preorder(Bit_node p){
    if(p){
        bit_printnode(p);
        bit_preorder(p->l);
        bit_preorder(p->r);
    }
}

/*VISITA POSTORDER*/
void bit_postorder(Bit_node p){
    if(p){
        bit_postorder(p->l);
        bit_postorder(p->r);
        bit_printnode(p);
    }
}

/*RICERCA DI UNA CHIAVE*/
Bit_node bist_search(Bit_node p, int k){
	if(!p)
		return NULL;
	int res=cmp(k,key(p->key));
	if(res==0)
		return p;
	if(res<0)
		return bist_search(p->right,key);
	return bist_search(p->left,key);
}

/*RICERCA DEL PADRE DI UN NODO*/
int bist_searchparent(Bit_node r, int k, Bit_node *parent, Bit_node *p){
	int res;
	*parent=NULL;
	*p=r;
	if(!r)
		return -1;
	while(*p&&(res=cmp(k,(*p)->item))!=0){
		*parent=*p;
		*p=res<0?(*p)->l:(*p)->r;
	}
	if(*p==NULL) /*non ci sono nodi con chiave k*/
		return -1;
	return 0;
}