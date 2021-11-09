package sa.edu.twuaiq.jsonarrayexample

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ProductsRecyclerViewAdapter(private val list: List<ProductModel>) :
    RecyclerView.Adapter<ProductsRecyclerViewAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsRecyclerViewAdapter.ProductViewHolder {

        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.product_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val item = list[position]

        holder.titleTextView.text = item.title
        holder.descriptionTextView.text = item.description
        holder.priceTextView.text = item.price.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.product_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.product_description)
        val priceTextView: TextView = itemView.findViewById(R.id.product_price)
    }

}