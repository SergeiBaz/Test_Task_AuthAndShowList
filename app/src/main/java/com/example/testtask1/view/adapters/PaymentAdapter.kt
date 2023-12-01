package com.example.testtask1.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask1.databinding.ItemPaymentBinding
import com.example.testtask1.model.Payment

class PaymentAdapter : RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {
    private var payments: List<Payment> = ArrayList()

    class PaymentViewHolder(val binding: ItemPaymentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val binding = ItemPaymentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return PaymentViewHolder(binding)
    }

    override fun getItemCount(): Int = payments.size

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val payment = payments[position]
        with(holder.binding) {
            paymentText.text = payment.title
            amoutText.text = payment.amount
            cardText.text = " MASTERCARD ${payment.created}"
        }
    }

    fun setPayments(paymentsList: List<Payment>) {
        this.payments = paymentsList
        notifyDataSetChanged()
    }
}