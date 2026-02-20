# Recycle Bin Feature - Quick Start Guide

## How to Test the New Recycle Bin Feature

### Backend Changes (Automatic)
The backend has been updated with:
- ✅ New API endpoints for active/deleted products
- ✅ 30-day automatic deletion scheduler
- ✅ Separate product filtering

### Frontend Changes
New Recycle Bin page added to Admin dashboard with full functionality.

---

## Testing Steps

### 1. Restart Backend Server
The backend is already running, but you may need to rebuild if you make changes:

```bash
cd c:\Users\yalam\Downloads\Inventory-mile-3-main
mvn spring-boot:run
```

Wait for: "Started InventorySystemApplication"

### 2. Frontend is Already Running
Your frontend should already be running on http://localhost:3000

If not, start it:
```bash
cd frontend
npm run dev
```

### 3. Login as Admin
- URL: http://localhost:3000/login
- Email: yalamarthisabdha@gmail.com
- Password: Your admin password

### 4. Test Product Deletion
1. Navigate to **Products** page
2. Click the **Delete** button (red trash icon) on any product
3. Confirm the deletion
4. Notice: Product disappears from Products page
5. Success message: "Product moved to Recycle Bin"

### 5. View Recycle Bin
1. Click **Recycle Bin** in the left sidebar (trash icon)
2. You should see the deleted product with:
   - Product details
   - Deletion date
   - Days remaining (should show "30 days" in green)

### 6. Test Search in Recycle Bin
1. Type in the search box at the top
2. Products filter as you type
3. Search works across: SKU, Product Name, Category, Supplier

### 7. Test Product Restore
1. In Recycle Bin, click the **Restore** button (green refresh icon)
2. Confirm the restoration
3. Success message: "Product restored successfully!"
4. Navigate back to Products page
5. The product should be back in the active list

### 8. Verify Active Products Only
1. Go to Products page
2. Verify that NO deleted products show up
3. Only active products should be visible
4. "Status" column is removed (all products are active)

---

## What Changed?

### Products Page
- ✅ Removed "Active" status column
- ✅ Removed restore button
- ✅ Only shows active products
- ✅ Delete moves to Recycle Bin (not permanent)
- ✅ Updated confirmation message

### New Recycle Bin Page
- ✅ Shows all deleted products
- ✅ Search functionality
- ✅ Days remaining countdown
- ✅ Color-coded warnings (green/orange/red)
- ✅ Restore button per product
- ✅ Permanent delete button (manual override)

### Backend
- ✅ Separate endpoints: `/api/admin/products/active` and `/api/admin/products/deleted`
- ✅ Changed retention from 5 days to 30 days
- ✅ Automatic cleanup scheduler (runs daily at 2 AM)

---

## Expected Behavior

### Day 1-25 (Green)
- Product shows in Recycle Bin with green "X days" remaining
- Safe period - plenty of time to restore

### Day 26-29 (Orange)
- Color changes to orange (warning)
- "6-10 days remaining"

### Day 30+ (Red - Critical)
- Color changes to red (critical)
- "5 days or less"
- Product will be permanently deleted soon

### After 30 Days (Automatic)
- Scheduler runs at 2:00 AM daily
- Products older than 30 days are permanently deleted
- Cannot be recovered after this point

---

## Quick Visual Test

1. **Delete a product** → Should disappear from Products
2. **Check Recycle Bin** → Should show deleted product
3. **Restore the product** → Should return to Products
4. **Check Products again** → Should show restored product

---

## Navigation

```
Admin Dashboard
├── Overview
├── Products (active only)
├── Stock In
├── Stock Out
├── Reports
├── Recycle Bin ← NEW!
└── Employees
```

---

## Troubleshooting

### Products still showing deleted items?
- The API now uses `/products/active` endpoint
- Check browser console for API errors
- Hard refresh the page (Ctrl+F5)

### Recycle Bin not showing?
- Clear browser cache
- Verify backend is running
- Check `/api/admin/products/deleted` endpoint

### Days remaining incorrect?
- Verify system date/time is correct
- Check server timezone settings

---

## Color Legend

🟢 **Green (>10 days):** Safe - Product has plenty of time before deletion  
🟠 **Orange (6-10 days):** Warning - Product will be deleted soon  
🔴 **Red (≤5 days):** Critical - Product will be permanently deleted very soon  

---

## Summary

✅ **Products Page:** Only active products, no Status column  
✅ **Recycle Bin:** All deleted products with 30-day retention  
✅ **Restore:** One-click restore from Recycle Bin  
✅ **Auto-Cleanup:** Automatic permanent deletion after 30 days  
✅ **Visual Warnings:** Color-coded time remaining indicators  

**Note:** The backend is currently running. Just refresh your browser and start testing! 🚀
