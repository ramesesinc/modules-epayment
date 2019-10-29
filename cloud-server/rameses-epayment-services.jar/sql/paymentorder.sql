[movePaymentOrderToPaid]
INSERT INTO paymentorder_paid SELECT * FROM paymentorder WHERE objid=$P{paymentrefid}

[movePaymentOrderToCancelled]
INSERT INTO paymentorder_cancelled SELECT * FROM paymentorder WHERE objid=$P{paymentrefid}
